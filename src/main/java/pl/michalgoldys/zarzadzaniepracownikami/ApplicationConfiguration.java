package pl.michalgoldys.zarzadzaniepracownikami;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan
public class ApplicationConfiguration  {	
	
	@Autowired
	@Bean
	public InternalResourceViewResolver settingInternalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}				
	/*
	@Autowired
	@Bean
	public LocalContainerEntityManagerFactoryBean settingEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPackagesToScan("pl.michalgoldys");
		lcemfb.getPersistenceProvider();
		lcemfb.getJpaVendorAdapter();
		return lcemfb;
	}
	*/
	@Autowired
	@Bean
	public HibernateJpaVendorAdapter settingHibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setShowSql(true);
		hjva.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	return hjva;
	}
	
}