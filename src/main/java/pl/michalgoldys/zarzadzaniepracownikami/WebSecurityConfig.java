package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	 protected void configure(final HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests().anyRequest().denyAll()
	            
	            .and()
	            
	            .authorizeRequests()
	            	.antMatchers("/customer").hasRole("USER")
	            	.antMatchers("/customer/customerMenu").hasRole("USER")
	            	.antMatchers("/customer/showingCustomers").hasRole("USER")
	            	.antMatchers("/customer/showingCustomersBilling").hasRole("USER")
	            	
	            	.antMatchers("/customer").hasRole("ADMIN")
	            	.antMatchers("/customer/customerMenu").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomers").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomersBilling").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomersBillings/customerBillingDetalis").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomers/customerDetalis").hasRole("ADMIN")
	            	.antMatchers("/customer/addingCustomer").hasRole("ADMIN")
	            	
	                .antMatchers("/login*").permitAll()
	                
	                .and()
	                
	                .formLogin()
	                .loginPage("/login.html")
	                .loginProcessingUrl("/doLogin")
	                .defaultSuccessUrl("/customer/customerMenu", true)
	        		.failureUrl("/login.html?error=true")
	        
	        		.and()
	        		
	        		.httpBasic()
	        		
	        		.and();
	 }
	 
	 @Override
	 protected void configure(final AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	            .password(passwordEncoder().encode("user1234"))
	            .roles("USER")
	          .and()
	          .withUser("admin")
	          	.password(passwordEncoder().encode("admin1234"))
	          	.roles("ADMIN");
	    }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
