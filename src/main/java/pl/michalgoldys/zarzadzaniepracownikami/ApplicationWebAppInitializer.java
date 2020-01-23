package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Configuration
public class ApplicationWebAppInitializer implements WebApplicationInitializer {
	
	@Override
    public void onStartup(ServletContext container) {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		container.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(ApplicationWebMvcConfig.class);

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
