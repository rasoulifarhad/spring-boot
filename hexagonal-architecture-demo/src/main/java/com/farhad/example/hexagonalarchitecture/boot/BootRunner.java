package com.farhad.example.hexagonalarchitecture.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BootRunner {
	

	@Bean
	CommandLineRunner initDb(JdbcTemplate jdbcTemplate) {

		return args -> {

			jdbcTemplate.execute("DROP TABLE account IF EXISTS");
			String createTable = "CREATE TABLE account(" + 
			 	"accountNo Long NOT NULL, balance Numeric NOT NULL)";
			jdbcTemplate.execute(createTable);
			String sql = "INSERT INTO account(accountNo, balance) VALUES (?,?)";
			jdbcTemplate.update(sql, 5, 5000);
		}; 
	}
}
