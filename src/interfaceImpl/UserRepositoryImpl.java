package interfaceImpl;

import java.util.UUID;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import custome_interface.UserRepository;
import model.User;
import model.UserMapper;
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
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String sql = "INSERT INTO tb_user(id,name,password)VALUES(?,?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
		return user;
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
	public User query(String userId) {
		String sql = "SELECT * FROM tb_user WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
	}
	}
