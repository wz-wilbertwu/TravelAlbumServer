package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TravelMapper implements RowMapper<Travel>{

	@Override
	public Travel mapRow(ResultSet rs, int arg1) throws SQLException {
		Travel travel = new Travel();
		travel.setId(rs.getString("id"));
		travel.setUserId(rs.getString("user_id"));
		travel.setTitle(rs.getString("title"));
		travel.setTime(rs.getString("time"));
		return travel;
	}

}
