package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final String userQuerySyntax= "SELECT USERNAME, PASSWORD, ENABLED FROM USER WHERE USERNAME=?";
	private final String authoritiesQuerySyntax ="SELECT USERNAME, AUTHORITY FROM USER_AUTHORITIES WHERE USERNAME=?";

	@Autowired
	DataSource dataSource;

	 @Override
	 protected void configure(final HttpSecurity http) throws Exception {
	        http
	 
	            .authorizeRequests()
	            
	            	.antMatchers("/customer").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerMenu").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/showingCustomers").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/showingCustomersBillings").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel").hasAnyRole("USER","ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel/customerTechnicalDetails").hasAnyRole("USER","ADMIN")
					.antMatchers("/customer/showingCustomersInteractive/**").hasAnyRole("USER","ADMIN")

	            	.antMatchers("/customer/showingCustomersBillings/customerBillingDetails").hasRole("ADMIN")
	            	.antMatchers("/customer/showingCustomers/customerDetails").hasRole("ADMIN")
	            	.antMatchers("/customer/addingCustomer").hasRole("ADMIN")
	            	.antMatchers("/customer/userscontrolpanel").hasRole("ADMIN")
	            	.antMatchers("/customer/customerTechnicalPanel/customerTechnicalDetails/**").hasRole("ADMIN")
	            	
	                .antMatchers("/login*", "/index").permitAll()
	                
	                .antMatchers("/css/**", "/images/**", "/jquery/**" , "/bootstrap/**", "/bootstrap-datepicker/**").permitAll()

	                .anyRequest().denyAll()
	                
	                .and()
	                
	                .formLogin()
	                .loginPage("/login.html")
	                .loginProcessingUrl("/doLogin")
	                .defaultSuccessUrl("/customer/customerMenu", true)
	        		.failureUrl("/login.html?error=true");
	 }

	 @Override
	 protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder)
		 throws Exception {
	 	authenticationManagerBuilder
				.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(userQuerySyntax)
				.authoritiesByUsernameQuery(authoritiesQuerySyntax)
				.passwordEncoder(passwordEncoder());
	 }
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
