package com.famas.demo.configs;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JdbiConfig {
	
	@Bean
	public HikariDataSource hikariDataSource()
	{
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&serverTimeZone=UTC");
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		
		return new HikariDataSource(hikariConfig);
	}
	
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(HikariDataSource datasource)
	{
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(datasource);
		return transactionManager;
		
	}
	
	
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSourceProxy (HikariDataSource datasource)
	{
		TransactionAwareDataSourceProxy transactionAwareDataProxy = new TransactionAwareDataSourceProxy(datasource);
		return transactionAwareDataProxy;
	}
	
	@Bean
	public Jdbi jdbiBean(TransactionAwareDataSourceProxy datasource)
	{
		Jdbi jdbi = Jdbi.create(datasource);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}

}
