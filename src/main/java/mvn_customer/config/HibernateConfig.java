package mvn_customer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class HibernateConfig {
 
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	sessionFactory.setDataSource(dataSource());
	sessionFactory.setPackagesToScan("mvn_customer.entities");
	sessionFactory.setHibernateProperties(hibernateProperties());
	return sessionFactory;
    }
    
    @Bean
    public DataSource dataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	//dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
	//dataSource.setUrl("jdbc:mysql://localhost:3306/mvc_crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
	dataSource.setUrl("jdbc:mysql://192.168.198.130:3306/mvn-customers?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
	
	dataSource.setUsername("mvc_crud");
	dataSource.setPassword("radek01");
	
	return dataSource;
    }
    
    
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    
    private final Properties hibernateProperties() {
	Properties hibernateProperties = new Properties();
	hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
	hibernateProperties.setProperty("hibernate.c3p0.pool_size","10");
	hibernateProperties.setProperty("hibernate.c3p0.min_size","5");
	hibernateProperties.setProperty("hibernate.c3p0.max_size","200");
	hibernateProperties.setProperty("hibernate.c3p0.timeout","1800");
	hibernateProperties.setProperty("hibernate.show_sql","false");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","validate");
	hibernateProperties.setProperty("hibernate.c3p0.acquire_increment","1");
	return hibernateProperties;
    }
    
 
    
}
