package com.vijay.jdk8related;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@FunctionalInterface
public interface FunctionalInterfacedemo {
	
	public void greeting();
	
	/* We can have as many default and static methods as much as we want 
	 * in functional interface but only single abstract method is allowed.
	 */
	
	default public void secondmethod()
	{
		
	}
	
	default public void thirdmethod()
	{
		
	}
	
	public static void fourthmethod()
	{
		
	}
	
	public static void fifthmethod()
	{
		
	}
	
	public static void main (String[] args)
	{
//		Using Function interface. 
		Function<String,Integer> f = x -> x.length();
		int a = f.apply("Vijay");
		System.out.println(a);

//		Chaining two functions using Function interface.
		Function<Integer, Integer> f1 = x -> x *2;
		int b = f.andThen(f1).apply("Vijay");
		System.out.println(b);

//		Using Bifunction which is also extended by binary operator
		BiFunction<String, String, String> f2 = (x, y) -> x+y;
		String na = f2.apply("Vijay ", "Bhangur");
		System.out.println(na);

//		Using Unary operator which is also extended by binary operator
		UnaryOperator<Integer> f3 = x -> x*10;
		int c=f3.apply(3);
		System.out.println(c);
		
//		Using predicate and negate.
		Predicate<Integer> f4 = x -> x>7;
		List <Integer> numb = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,30);
		List<Integer> fin = numb.stream().filter(f4.negate()).collect(Collectors.toList());
		System.out.println(fin);
	}

}
