package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setId(rs.getString("id"));
		return user;
	}

}
