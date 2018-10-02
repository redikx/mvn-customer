package mvn_customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("mvn_customer")
@EnableAspectJAutoProxy
@EnableWebMvc

public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	
	return viewResolver;
    }
    
}
