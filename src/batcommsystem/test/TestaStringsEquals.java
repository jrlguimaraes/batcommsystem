package batcommsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaStringsEquals {

	@Test
	public void test() {

		String obj1 = new String("xyz");

		String obj2 = new String("xyz");

		if (obj1 == obj2)
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");

		System.out.println("Using Equals:");

		if (obj1.equals(obj2))
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");

		System.out.println("The Java String class actually overrides \n"
				+ "the default equals() implementation in \n"
				+ "the Object class – and it overrides the \n"
				+ "method so that it checks only the values \n"
				+ "of the strings, not their locations in memory.");

		System.out.println("Hash Code:");

		if (obj1.hashCode() == obj2.hashCode())
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");

	}

}
