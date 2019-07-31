package main;

import SpringEx19_SpringAOP.ExeTimeCalculator;
import SpringEx19_SpringAOP.ImpeCalculator;
import SpringEx19_SpringAOP.RecCalculator;

public class Main {
	public static void main(String[] args) {
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}
}
