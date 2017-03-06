package interfaceImpl;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import custome_interface.TravelItemRepository;
import model.Travel;
import model.TravelItem;
import model.TravelItemMapper;
import model.TravelMapper;
@Component
public class TravelItemRepositoryImpl implements TravelItemRepository{
	private JdbcTemplate jdbcTemplate;
	
	/*public TravelItemRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	public TravelItemRepositoryImpl() {
	  BasicDataSource dataSource = new BasicDataSource();
	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
	  dataSource.setUsername("root");
	  dataSource.setPassword("password");
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public TravelItem add(TravelItem travelItem) {
		travelItem.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String sql = "INSERT INTO tb_travel_item "
				+ "(id,travel_id,description,image,time) "
				+ "VALUES(?,?,?,?,NOW())";
		jdbcTemplate.update(sql, travelItem.getId(), travelItem.getTravel_id(), 
				travelItem.getDescription(), travelItem.getImage());
		String querySql = "select * from tb_travel_item where id = ?";
		return jdbcTemplate.queryForObject(querySql, new TravelItemMapper(), travelItem.getId());
	}

	@Override
	public TravelItem update(TravelItem travelItem) {
		String sql = "UPDATE tb_travel_item set description=?, image=?,"
				+ "time=NOW() where id=?";
		jdbcTemplate.update(sql, travelItem.getDescription(), travelItem.getImage(), travelItem.getId());
		String querySql = "select * from tb_travel_item where id = ?";
		return jdbcTemplate.queryForObject(querySql, new TravelItemMapper(), travelItem.getId());
	}

	@Override
	public TravelItem delete(String id) {
		String querySql = "select * from tb_travel_item where id = ?";
		TravelItem travelItem = jdbcTemplate.queryForObject(querySql, new TravelItemMapper(), id);
		String sql = "DELETE FROM tb_travel_item WHERE id=?";
		jdbcTemplate.update(sql, id);
		return travelItem;
	}

	@Override
	public TravelItem query(String id) {
		String sql = "select * from tb_travel_item where id = ?";
		return jdbcTemplate.queryForObject(sql, new TravelItemMapper(), id);
	}

	@Override
	public List<TravelItem> queryAll(String travel_id) {
		String sql = "select * from tb_travel_item where travel_id = ?";
		return jdbcTemplate.query(sql, new Object[]{travel_id}, new TravelItemMapper());
	}

}
