package config;

import javax.servlet.Filter;
import javax.servlet.annotation.MultipartConfig;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller", "custome_interface", "interfaceImpl", "config"})
public class WebConfig extends WebMvcConfigurerAdapter {
	  @Bean
	  public ViewResolver viewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/jsp/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	  }
	  
	  @Bean
	  public DataSource dataSource() {
		  BasicDataSource dataSource = new BasicDataSource();
		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/db_develop?serverTimezone=UTC");
		  dataSource.setUsername("root");
		  dataSource.setPassword("password");
		  return dataSource;
	  }
	  
	  
	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
	  
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    // TODO Auto-generated method stub
	    super.addResourceHandlers(registry);
	  }
	}
