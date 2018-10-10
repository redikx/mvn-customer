package mvn_customer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource ds_security;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/loginPage")
	.loginProcessingUrl("/authenticateTheUser")
	.defaultSuccessUrl("/customer/list")
	.permitAll()
	.and().logout()
	.permitAll();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(ds_security);
    
    /*@SuppressWarnings("deprecation")
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	@SuppressWarnings("unused")
	UserBuilder users = User.withDefaultPasswordEncoder();
	
	auth.inMemoryAuthentication()
	.withUser(users.username("admin").password("radek01").roles("admin"));
    */
    
    }
}
