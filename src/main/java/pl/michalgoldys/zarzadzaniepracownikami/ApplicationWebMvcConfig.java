package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class ApplicationWebMvcConfig implements WebMvcConfigurer{
	
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
	        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
	     //   registry.addResourceHandler("/customer/**").addResourceLocations("/resources/teamplates/customer/");
	    }
}
