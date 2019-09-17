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
	 
	            .authorizeRequests()
	            
	            	.antMatchers("/customer").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerMenu").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/showingCustomers").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/showingCustomersBillings").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel/customerTechnicalDetalis").hasAnyRole("USER","ADMIN")

	            	.antMatchers("/customer/showingCustomersBillings/customerBillingDetalis").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomers/customerDetalis").hasRole("ADMIN")
	            	.antMatchers("/customer/addingCustomer").hasRole("ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel").hasRole("ADMIN")
	            	
	                .antMatchers("/login*").permitAll()
	                .antMatchers("/css/*").permitAll()
	                
	                .anyRequest().denyAll()
	                
	                .and()
	                
	                .formLogin()
	                .loginPage("/login.html")
	                .loginProcessingUrl("/doLogin")
	                .defaultSuccessUrl("/customer/customerMenu", true)
	        		.failureUrl("/login.html?error=true");
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
