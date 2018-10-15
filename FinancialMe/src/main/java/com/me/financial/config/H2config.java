package com.me.financial.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.me.financial.repository", 
		entityManagerFactoryRef = "h2EntityManager", 
		transactionManagerRef = "h2TransactionManager"
		)
public class H2config {

	@Bean
	public LocalContainerEntityManagerFactoryBean h2EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(h2DataSource());
		em.setPackagesToScan(new String[] { 
				"com.me.financial.model" 
		});

		HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.use_sql_comments", false);
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource h2DataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:~/h2");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager h2TransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(h2EntityManager().getObject());
		return transactionManager;
	}
	
}
