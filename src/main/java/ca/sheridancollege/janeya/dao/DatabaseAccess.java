package ca.sheridancollege.janeya.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.janeya.beans.MasterPassword;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public List<MasterPassword> checkCredentials(MasterPassword pswd) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM MasterPassword WHERE useremail = :useremail"
				+ " AND userpass = :userpass;";
		namedParam.addValue("useremail", pswd.getMstrUser());
		namedParam.addValue("userpass", pswd.getMsterPass());
		List<MasterPassword> results = jdbc.query(query, namedParam, 
				new BeanPropertyRowMapper<MasterPassword>(MasterPassword.class));
		return results;
	}
	
}
