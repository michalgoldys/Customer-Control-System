package pl.michalgoldys.zarzadzaniepracownikami;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
public class ApplicationConfiguration  {	
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder
		.create()
		.username("admin")
		.password("fajka12!@")
		.url("jdbc:mysql://localhost:3306/zarzadzaniepracownikamidb?createDatabaseIfNotExist=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
		.driverClassName("com.mysql.jdbc.Driver")
		.build();
	}
	
	@Bean
	public InternalResourceViewResolver settingInternalResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();;
		lcemfb.setDataSource(dataSource());
		lcemfb.setPackagesToScan("pl.michalgoldys");
		lcemfb.setJpaVendorAdapter(settingHibernateJpaVendorAdapter());
		return lcemfb;
	}
	
	@Bean
	public HibernateJpaVendorAdapter settingHibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setShowSql(true);
		hjva.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		hjva.setGenerateDdl(true);
	return hjva;
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager settingJpaTransactionManager() {
		JpaTransactionManager  transactionManager= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
	
}