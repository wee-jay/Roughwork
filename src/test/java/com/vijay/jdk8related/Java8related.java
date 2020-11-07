package com.vijay.jdk8related;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import turtlemint.turtle.steps.ForStreamAPIdemo;

public class Java8related {

	public static void main (String args[])
	{
		List<String> li = Arrays.asList("Tom", "John Doe", "Emanuel");
		
		li.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		});
		
		for (String data : li)
		{
			System.out.println(data);
		}
		
		int i =0;
		do 
		{
			System.out.println(li.get(i));
			i++;
		}
		while (i < li.size());
		
		Iterator<String> it = li.iterator();
		System.out.println("----------------Using Iterator----------------");
		while(it.hasNext()==true)
		{
			System.out.println(it.next());
		}
		
//		Method reference in java 8
		System.out.println("----------------Using Method Reference----------------");
		li.forEach(System.out :: println);
		
//		Lambda expression in java 8
		System.out.println("----------------Using Lambada Expression----------------");
		li.forEach(str -> System.out.println(str));
		
//		STREAMING API's
		System.out.println("----------------Using Stream API----------------");
		
		List<ForStreamAPIdemo> lis = Arrays.asList(
								 new ForStreamAPIdemo("Vijay Bhangur", 27, "Automation Test Engineer", "Pega"),
								 new ForStreamAPIdemo("Vikas Jindal", 28, "Tech Lead", "Turtlemint"),
								 new ForStreamAPIdemo("Vaibhav Sawant", 29 ,"Scrum Master", "Turtlemint"),
				 				 new ForStreamAPIdemo("Lipi Patel", 30, "Principal Engineer", "Turtlemint"),
				 				 new ForStreamAPIdemo("Suyog Sawant", 28, "FE/BE Developer", "Turtlemint"),
				 				 new ForStreamAPIdemo("Manish Soni", 32, "Product Owner", "Turtlemint"),
				 				 new ForStreamAPIdemo("Prathamesh Salap", 27, "FE/BE Developer", "Turtlemint"),
				 				 new ForStreamAPIdemo("Ketaki", 28, "Design/ UI / UX", "Turtlemint"));
		
		List<String> resul = lis.stream().filter(x -> x.getAge()>26 && x.getAge()<31)
					.map(ForStreamAPIdemo :: getName)
					.collect(Collectors.toList());
		
		resul.forEach(System.out :: println);
		
//		System.out.println(resul.getAge()+"-> "+resul.getCompany()+"-> "+resul.getDesignation());
		
		
	}
	
	
}
