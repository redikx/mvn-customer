package mvn_customer.config;

import java.beans.PropertyVetoException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("mvn_customer")
@EnableAspectJAutoProxy
@PropertySource("classpath:db_security.properties")
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;
    
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	
	return viewResolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

       // Register resource handler for CSS and JS
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
             .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }
    
    @Bean
    public DataSource ds_security() {
	
	// Create pool
	ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
	// set driver
	try {
	    securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
	} catch (PropertyVetoException e) {
	   throw new RuntimeException(e);
	}
	
	// looger info
	logger.info(">>>><<<< jdbc.driver " + env.getProperty("jdbc.driver"));
	logger.info(">>>><<<< jdbc.url " + env.getProperty("jdbc.url"));
	logger.info(">>>><<<< jdbc.user " + env.getProperty("jdbc.user"));
	logger.info(">>>><<<< jdbc.password " + env.getProperty("jdbc.password"));

	
	    
	
	// set database connection props
	securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	securityDataSource.setPassword(env.getProperty("jdbc.password"));
	securityDataSource.setUser(env.getProperty("jdbc.user"));
	securityDataSource.setInitialPoolSize(getIntProp("connection.pool.initialPoolSize"));
	securityDataSource.setMaxPoolSize(getIntProp("connection.pool.MaxPoolSize"));
	securityDataSource.setMinPoolSize(getIntProp("connection.pool.MinPoolSize"));
	securityDataSource.setMaxIdleTime(getIntProp("connection.pool.maxIdleTime"));
	return securityDataSource;
    }
    
    private int getIntProp(String propName) {
	String strPropValue = env.getProperty(propName);
	int intPopValue=Integer.parseInt(strPropValue);
	return intPopValue;
    }
    
}
