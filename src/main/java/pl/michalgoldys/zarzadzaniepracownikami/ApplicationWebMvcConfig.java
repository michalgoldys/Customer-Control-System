package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableSpringDataWebSupport
public class ApplicationWebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
	        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("/resources/webjars/");
	    }

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login.html");
	   }
}