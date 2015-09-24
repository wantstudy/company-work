package com.test.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Java8Tester {

	@FunctionalInterface
	interface stringFormt {
		 String format(String delimiter, List<String> list);
	}
	public static List<String> getList(){
		List<String> list = Arrays.asList("1","2","3");
		return list;
	}
	@Test
	public void testFormat(){
		List<String> list = getList();
		stringFormtvoid(String::join,",",list);
	}
	
	@Test
	public void testLambda(){
		List<String> list = getList();
		List<String> list2 = new ArrayList();
		list.forEach((name) -> list2.add(name));
		list2.forEach(System.out::println);
	}
	
	public static void stringFormtvoid(stringFormt format,String delimiter, List<String> list){
		String format2 = format.format(delimiter, list);
		System.out.println(format2);
	}
	
	public static void main(String args[]){

		Java8Tester tester = new Java8Tester();


		//with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		//with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		//with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));	   
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		//with parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		//without parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");	   
	}   

	interface MathOperation {
		int operation(int a, int b);
	}  

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	} 

	static class testStringJoin{
	}

	@Test
	public void testStringjoiner(){
		List<String> strings = new LinkedList<>();
		strings.add("Java");strings.add("is");
		strings.add("cool");
		String message = String.join(" ", strings);
		System.out.println(message);
		//message returned is: "Java is cool"

		Set<String> stringset = new LinkedHashSet<>();
		stringset.add("Java"); stringset.add("is");
		stringset.add("very"); stringset.add("cool");
		String messageset = String.join("-", stringset);
		System.out.println(messageset);
		//message returned is: "Java-is-very-cool"

		StringJoiner joiner = new StringJoiner(",");
		StringBuilder strb = new StringBuilder();
		strb.append("1,");
		strb.append("2,");
		strb.append("3");
		for (CharSequence string : strb.toString().split(",")) {
			joiner.add(string);
		}
		System.out.println(joiner.toString());
	}
	
	interface Drive{
		default void driver(){
			System.out.println("driver");
		}
	}	
	
	class drivers implements Drive{
		@Test
		public void driver(){
			Drive.super.driver();
		}
	}

}
