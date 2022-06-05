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

	public List<User> checkCredentials(String username, String password) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM master_login WHERE username = :username"
				+ " AND passwd = :password;";
		namedParam.addValue("username", username);
		namedParam.addValue("password", password);
		List<User> result = jdbc.query(query, namedParam, new BeanPropertyRowMapper<User>(User.class));
		return result;
	}

	public List<Password> selectPasswords(String userId) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM 5vun7jr5dnwjq8y8;";
		// namedParam.addValue("userId", userId);
		List<Password> results = jdbc.query(query, namedParam, new BeanPropertyRowMapper<Password>(Password.class));
		return results;
	}

	public long registerUser(User user) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String insert = "INSERT INTO master_login (userid, username, passwd) VALUES (:userid, :username, :password);";
		namedParam.addValue("userid", user.getId());
		namedParam.addValue("username", user.getUser());
		namedParam.addValue("password", user.getPass());
		long rowsAffected = jdbc.update(insert, namedParam);
		return rowsAffected;
	}

	public long deleteUser(String userId) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String delete = "DELETE";
		namedParam.addValue("userId", userId);
		long rowsAffected = jdbc.update(delete, namedParam);
		return rowsAffected;
	}

	public User selectAPassword(String userId, String website) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String query = "SELECT * FROM :";
		return new User();
	}

	public long createSchema(String userId) {
		MapSqlParameterSource namedParam = new MapSqlParameterSource();
		String create = "CREATE TABLE :userId (website varchar(255), email varchar(255), password varchar(255));";
		namedParam.addValue("userId", userId);
		long rowsAffected = jdbc.update(create, namedParam);
		return rowsAffected;
	}
}
