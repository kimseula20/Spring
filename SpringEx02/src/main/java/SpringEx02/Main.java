package SpringEx02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContextEx.class);
		
		Practice p = ctx.getBean("practice", Practice.class);
		String msg = p.example("Spring");
		System.out.println(msg);
		
		Practice p1 = ctx.getBean("practice1", Practice.class);
		String msg1 = p1.example("Spring");
		System.out.println(msg1);
		
		Practice p2 = ctx.getBean("practice2", Practice.class);
		String msg2 = p2.example("Spring");
		System.out.println(msg2);
	}
}
