package interfaceImpl;

import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import custome_interface.SyncRepository;
import model.Travel;

@Component
public class SyncRepositoryImpl implements SyncRepository{
	private JdbcTemplate jdbcTemplate;
	
	/*public TravelItemRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	public SyncRepositoryImpl() {
	  BasicDataSource dataSource = new BasicDataSource();
	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
	  dataSource.setUsername("root");
	  dataSource.setPassword("password");
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Travel> syncTravel(String userId, String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Travel> syncTravelItem(String travelId, String time) {
		// TODO Auto-generated method stub
		return null;
	}

}
