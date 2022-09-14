package com.naresh.config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.naresh.dao.AccountDAO;
import com.naresh.dao.TransactionDAO;
import com.naresh.dao.UserDAO;
import com.naresh.demo.HelloBean;

@Configuration
public class BeanConfig {

	@Bean
	// @Scope(scopeName = "singleton")
	@Scope(scopeName = "prototype")
	public UserDAO userDAO() {
		UserDAO userDAO = new UserDAO();
		return userDAO;
	}

	// constructor based injection
	@Bean
	public AccountDAO accountDAO(DataSource dataSource) {
		AccountDAO accountDAO = new AccountDAO(dataSource);
		return accountDAO;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("system");
		ds.setPassword("oracle");
		return ds;
	}

}
