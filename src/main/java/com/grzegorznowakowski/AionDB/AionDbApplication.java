package com.grzegorznowakowski.AionDB;

import com.grzegorznowakowski.AionDB.db.config.CountryRoutingDataSource;
import com.grzegorznowakowski.AionDB.db.config.DatabaseConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
@EnableConfigurationProperties(DatabaseConfigurations.class)
public class AionDbApplication implements WebMvcConfigurer {

	@Autowired
	DatabaseConfigurations databaseConfigurations;

	@Bean
	public DataSource dataSource() {
		CountryRoutingDataSource dataSource = new CountryRoutingDataSource();
		dataSource.setTargetDataSources(databaseConfigurations.createTargetDataSources());
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(AionDbApplication.class, args);
	}

}
