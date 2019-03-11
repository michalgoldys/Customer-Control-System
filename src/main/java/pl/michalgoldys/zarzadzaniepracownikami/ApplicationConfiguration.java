package pl.michalgoldys.zarzadzaniepracownikami;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories
public class ApplicationConfiguration {

	@Bean
	public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/zarzadzaniepracownikamidb?createDatabaseIfNotExist=true");
        dataSource.setUsername("admin");
        dataSource.setPassword("fajka12!@");
        return dataSource;
	}
	
}