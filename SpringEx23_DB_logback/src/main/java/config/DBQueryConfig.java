package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dbquery.DBQuery;

@Configuration
public class DBQueryConfig {
	@Autowired
	private javax.sql.DataSource dataSource;

	@Bean
	public DBQuery dbQuery() {
		return new DBQuery(dataSource);
	}
}
