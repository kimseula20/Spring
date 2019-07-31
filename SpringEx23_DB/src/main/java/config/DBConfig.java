package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx23_DB.MemberDao;

@Configuration
public class DBConfig {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/springdb?characterEncoding=utf8");
		ds.setUsername("spring");
		ds.setPassword("spring");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true); 	//유휴 커넥션 검사
		ds.setMinEvictableIdleTimeMillis(1000*60*3); 	//최소 유휴 시간 3분
		ds.setTimeBetweenEvictionRunsMillis(1000*10); 	//10초 주기
		return ds;
	}
	
}
