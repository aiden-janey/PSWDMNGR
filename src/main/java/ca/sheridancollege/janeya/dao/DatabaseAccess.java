package ca.sheridancollege.janeya.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.janeya.beans.Password;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public long checkCredentials(Password password) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM password WHERE useremail = :useremail"
				+ " AND userpass = :userpass;";
		namedParam.addValue("useremail", password.getUserEmail());
		namedParam.addValue("userpass", password.getUserPass());
		long numOfRows = jdbc.query(query, namedParam, new BeanPropertyRowMapper<Password>(Password.class));
		return numOfRows
	}
	
}
