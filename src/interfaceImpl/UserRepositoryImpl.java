package interfaceImpl;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import custome_interface.UserRepository;
import model.User;
import testTool.MyTool;
@Component
public class UserRepositoryImpl implements UserRepository{
	private JdbcTemplate jdbcTemplate;
	
	public UserRepositoryImpl() {
	  BasicDataSource dataSource = new BasicDataSource();
	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
	  dataSource.setUsername("root");
	  dataSource.setPassword("password");
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public User add(User user) {
		String sql = "INSERT INTO tb_user(id,name,password)VALUES(?,?,?)";
		jdbcTemplate.update(sql, "16", user.getName(), user.getPassword());
		return null;
	}

	@Override
	public User update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User query() {
		// TODO Auto-generated method stub
		return null;
	}
	}
