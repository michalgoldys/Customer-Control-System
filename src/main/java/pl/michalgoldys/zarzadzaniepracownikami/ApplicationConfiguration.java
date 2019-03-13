package pl.michalgoldys.zarzadzaniepracownikami;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
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
public class ApplicationConfiguration {	
	
	@Autowired
	@Bean
	public void settingInternalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
	}				
	
	@Autowired
	@Bean
	public void settingEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.getDataSource();
		lcemfb.setPackagesToScan("pl.michalgoldys");
		lcemfb.getJpaVendorAdapter();
	}
	
	@Autowired
	@Bean
	public void settingHibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setShowSql(true);
		hjva.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");		
	}
	
	@Autowired
	@Bean
	public void settingJpaProperties() {
		JpaProperties jp = new JpaProperties();
		
		
	}
	
}