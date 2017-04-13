package config;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.filter.DelegatingFilterProxy;
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends 
		WebSecurityConfigurerAdapter{
	  public DataSource dataSource() {
		  BasicDataSource dataSource = new BasicDataSource();
		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
		  dataSource.setUsername("root");
		  dataSource.setPassword("password");
		  return dataSource;
	  }
	private DataSource dataSource;
	public SecurityConfig() {
		this.dataSource = dataSource();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		/*authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");*/
		String query = "select name,password,true from tb_user where name = ?";
		authenticationManagerBuilder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query)
		.authoritiesByUsernameQuery("select name,'ROLE_USER' from tb_user where name = ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.csrf().disable();
		
		http
			.authorizeRequests()
			.regexMatchers("/Travel/.*").authenticated()
			.regexMatchers("/TravelItem/.*").authenticated()	
			.regexMatchers("/User/.*").permitAll();
	}
}
