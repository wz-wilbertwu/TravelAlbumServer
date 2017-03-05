package interfaceImpl;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import custome_interface.TravelRepository;
import model.Travel;
import model.TravelMapper;
@Component
public class TravelRepositoryImpl implements TravelRepository{
	private JdbcTemplate jdbcTemplate;
	public TravelRepositoryImpl() {
		  BasicDataSource dataSource = new BasicDataSource();
		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
		  dataSource.setUsername("root");
		  dataSource.setPassword("password");
		  this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	@Override
	public Travel add(Travel travel) {
		travel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String sql = "INSERT INTO tb_travel "
				+ "(id,user_id,title,time) "
				+ "VALUES(?,?,?,NOW())";
		jdbcTemplate.update(sql, travel.getId(), travel.getUserId(), 
				travel.getTitle());
		String querySql = "select * from tb_travel where id = ?";
		return jdbcTemplate.queryForObject(querySql, new TravelMapper(), travel.getId());
	}

	@Override
	public Travel update(Travel travel) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_travel set title=?, time=NOW() where id=?";
		jdbcTemplate.update(sql, travel.getTitle(), travel.getId());
		String querySql = "select * from tb_travel where id = ?";
		return jdbcTemplate.queryForObject(querySql, new TravelMapper(), travel.getId());
	}

	@Override
	public Travel delete(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_travel WHERE id=?";
		jdbcTemplate.update(sql, id);
		return null;
	}

	@Override
	public Travel query(String id) {
		String sql = "select * from tb_travel where id = ?";
		return jdbcTemplate.queryForObject(sql, new TravelMapper(), id);
	}
	
	@Override
	public List<Travel> queryAll(String usr_id) {
		String sql = "select * from tb_travel where user_id = ?";
		return jdbcTemplate.query(sql, new Object[]{usr_id}, new TravelMapper());
	}

}
