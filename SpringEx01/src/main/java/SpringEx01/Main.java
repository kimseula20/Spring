package SpringEx01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		// Greeter g = ctx.getBean("greeter", Greeter.class);
		// String msg = g.greet("스프링");
		// System.out.println(msg);
//		Greeter g1 = ctx.getBean("greeter", Greeter.class);
//		Object g2 = ctx.getBean("greeter", Object.class);
//		System.out.println("(g1 == g2) = " + (g1 == g2));
		
		Greeter g1 = ctx.getBean("greeter1", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		Greeter g3 = ctx.getBean("greeter", Greeter.class);
		Object g4 = ctx.getBean("greeter1", Greeter.class);
		Object g5 = ctx.getBean("greeter1", Greeter.class);
		System.out.println("1. (g1 == g2) = " + (g1 == g2));
		System.out.println("2. (g3 == g4) = " + (g3 == g4));
		System.out.println("3. (g4 == g5) = " + (g4 == g5));
		System.out.println("--------------------------------------");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("spring");
		System.out.println("1. " + msg);
		Greeter gr = ctx.getBean("greeter1", Greeter.class);
		String msg1 = gr.greet("spring");
		System.out.println("2. " + msg1);
		ctx.close();
	}
}
