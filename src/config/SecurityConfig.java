package config;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.filter.DelegatingFilterProxy;
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends 
		WebSecurityConfigurerAdapter{
	private DataSource dataSource;
	@Autowired
	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Bean
	  Filter springSecurityFilterChain() {
		  DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		  return delegatingFilterProxy;
	  }
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		/*authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");*/
		String query = "select name from tb_user where name = ?";
		authenticationManagerBuilder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query);
	}
}
