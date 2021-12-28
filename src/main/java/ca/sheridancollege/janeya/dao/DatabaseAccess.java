package ca.sheridancollege.janeya.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.janeya.beans.Password;
import ca.sheridancollege.janeya.beans.User;

@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public User checkCredentials(User pswd) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM user WHERE mstrUser = :useremail"
				+ " AND mstrPass = :userpass;";
		namedParam.addValue("useremail", pswd.getUser());
		namedParam.addValue("userpass", pswd.getPass());
		User result = (User) jdbc.query(query, namedParam, new BeanPropertyRowMapper<User>(User.class));
		return result;
	}
	
	public List<Password> selectPasswords(){
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM password;";
		List<Password> results = jdbc.query(query, namedParam, new BeanPropertyRowMapper<Password>(Password.class));
		return results;
	}
}
