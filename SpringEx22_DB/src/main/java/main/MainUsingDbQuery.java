package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DBConfig;
import config.DBQueryConfig;
import dbquery.DBQuery;

public class MainUsingDbQuery {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(DBConfig.class, DBQueryConfig.class);

		DBQuery dbQuery = ctx.getBean(DBQuery.class);
		int count = dbQuery.count();
		System.out.println(count);
		ctx.close();
	}
}
