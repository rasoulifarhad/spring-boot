package com.farhad.example.hexagonalarchitecture.infrastructure.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.farhad.example.hexagonalarchitecture.domain.model.Account;

// For persistence we extend the Spring JdbcDaoSupport class. 

@Repository
public class SpringDataAccountRepository extends JdbcDaoSupport {
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public Account findByAccountNo(Long accountNo) {
		String sql = "SELECT * FROM account WHERE accountNo = ?";
		return getJdbcTemplate().queryForObject(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setAccountNo(rs.getLong("accountNo"));
				account.setAccountBalance(rs.getBigDecimal("balance"));
				return account;
			}
			
		}, accountNo);
	}

	public void save(Account account) {
		String sql = "UPDATE account SET balance= ? WHERE accountNo = ?";
		getJdbcTemplate().update(sql, new Object[] {account.getAccountBalance(), account.getAccountNo()});
	}
}
