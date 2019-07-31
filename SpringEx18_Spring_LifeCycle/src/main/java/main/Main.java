package main;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import SpringEx18_Spring_LifeCycle.Client2;
import config.AppContext;

public class Main {
	public static void main(String[] args) throws IOException{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Client2 client = ctx.getBean(Client2.class);
		client.send2();
		ctx.close();
		
	}
}
