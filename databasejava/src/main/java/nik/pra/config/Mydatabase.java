package nik.pra.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import nik.pra.dao.StudentDaoImpl;


@Configuration
public class Mydatabase {
		@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mydata");
		datasource.setUsername("root");
		datasource.setPassword("qwerty12345");
		
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbctemplate()
	{
		JdbcTemplate jdbctemplate= new JdbcTemplate();
		jdbctemplate.setDataSource(dataSource());
		return jdbctemplate;
	}
	
	@Bean
	public StudentDaoImpl studentdaoimpl()
	{
		StudentDaoImpl st = new StudentDaoImpl();
		st.setJdbctemplate(jdbctemplate());
		
		return st;
	}
	
}
	
	
	


