package turtlemint.turtle.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratingDifferentWays {

	public static void main(String[] args) {
		
		ArrayList<String> movies = new ArrayList<String>();
		movies.add("Get out !!");
		movies.add("Insidious");
		movies.add("Annable");
		movies.add("The Rite");
		movies.add("The Descent");
		
		System.out.println("--------Iterating using forEach method using lambda expression--------");
		movies.forEach(elem->
		{
			System.out.println(elem);
		});
		
		System.out.println("--------Iterating using iterator method--------");
		Iterator<String> it = movies.iterator();
		while(it.hasNext())
		{
			String show = it.next();
			System.out.println(show);
		}
		
		System.out.println("--------Iterating using forEachremaining method using lambda expression--------");
		Iterator<String> itt = movies.iterator();
		itt.forEachRemaining(shows ->{
			System.out.println(shows);
		});
		
		System.out.println("--------Iterating using for every element in object--------");
		for(String show : movies)
		{
			System.out.println(show);
		}
		
		System.out.println("--------Iterating using for listiterator but in reverse order--------");
		ListIterator<String> mom= movies.listIterator(movies.size());
		while (mom.hasPrevious())
		{
			String show = mom.previous();
			System.out.println(show);
		}
		System.out.println("_-_-_-_-_-Iterating using METHOD REFERENCE (JAVA 8 related)_-_-_-_-_-");
		movies.forEach(System.out :: println);
	}

}
