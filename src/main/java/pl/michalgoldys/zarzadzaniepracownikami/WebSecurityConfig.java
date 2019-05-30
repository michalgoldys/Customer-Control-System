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
	        	.csrf().disable()
	            .authorizeRequests()
	            	.antMatchers("/customer/**").hasRole("USER")
	                .antMatchers("/login*").permitAll()
	                .and()
	                .formLogin()
	                .loginPage("/login.html")
	                .loginProcessingUrl("/doLogin")
	                .defaultSuccessUrl("/customer/customerMenu", true);

	 }
	 
	 @Override
	 protected void configure(final AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	            .password(passwordEncoder().encode("1234"))
	            .roles("USER");
	    }
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
