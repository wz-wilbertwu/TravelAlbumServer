package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TravelItemMapper implements RowMapper<TravelItem>{

	@Override
	public TravelItem mapRow(ResultSet rs, int arg1) throws SQLException {
		TravelItem travelItem = new TravelItem();
		travelItem.setDescription(rs.getString("description"));
		travelItem.setId(rs.getString("id"));
		travelItem.setImage(rs.getString("image"));
		travelItem.setTime(rs.getString("time"));
		travelItem.setTravel_id(rs.getString("travel_id"));
		return travelItem;
	}

}
