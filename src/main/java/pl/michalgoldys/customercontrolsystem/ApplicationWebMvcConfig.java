package pl.michalgoldys.customercontrolsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
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
			registry.addResourceHandler("/jquery/**").addResourceLocations("/webjars/jquery/");
			registry.addResourceHandler("/bootstrap/**").addResourceLocations("/webjars/bootstrap/");
			registry.addResourceHandler("/bootstrap-datepicker/**").addResourceLocations("/webjars/bootstrap-datepicker/");
	    }

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login.html");
	   }
}