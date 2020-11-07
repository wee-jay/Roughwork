package turtlemint.turtle.steps;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;




class listeditems
{

	private String name;
	private int age;
	
	public listeditems()
	{
		System.out.println("contructor of listeditems callsed.");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}



public class LinkedListDemo {

	public static void main(String[] args) {
		
		String p[]= {"arrayOne","arrayTwo","arrayThree"};
		LinkedList <String> lis = new LinkedList<String>();
		lis.add("Vijay");
		lis.add("Amey");
		lis.add("Shubham");
		lis.add("Anup");
		System.out.println(lis);
		lis.addFirst("pushedAtFirst");
		System.out.println(lis);
		System.out.println(lis.getFirst()+" This was at first");
		System.out.println(lis.getLast()+" This was at last");
		
		
		Predicate<Integer> fun = x -> x<12;
		List <Integer>lin = new LinkedList<Integer>();
		lin.add(10);
		lin.add(23);
		lin.add(43);
		lin.add(52);
		lin.add(11);
		lin.add(0);
		lin.add(11);
		lin.add(10);
		System.out.println("Before-->  "+lin);
//		lin.removeIf(fun);
		
		System.out.println("After-->  "+lin);
		
		listeditems obj = new listeditems();
		obj.setAge(23);
		obj.setName("Naveen");
		listeditems obj1 = new listeditems();
		obj1.setAge(24);
		obj1.setName("Mukesh");
		
		List <listeditems> objs = new LinkedList<listeditems>();
		objs.add(obj);
		objs.add(obj1);
		
		Comparator<Integer> ob = new Comparator<Integer>()
				{

					@Override
					public int compare(Integer o1, Integer o2) {
						if (o1>o2)
							return -1;
						else
							return 1;
					}
			
				};

		Collections.sort(lin,ob);
		System.out.println(lin);
		
		List <String>listr = new LinkedList<String>();
		listr.add("Vijay");
		listr.add("Amey");
		listr.add("Vijay");
		listr.add("Vijay");
		listr.add("Shubham");
		listr.add("Apqls");
		System.out.println(listr);
		Collections.sort(listr);
		
		Comparator<String> comp = new Comparator<String>()
				{

					@Override
					public int compare(String o1, String o2) {
						if(o1==o2)
							return 1;
						
						return 0;
					}
			
				};
		Collections.sort(listr, comp);
		
		System.out.println(listr.size());
		System.out.println(listr);
		for(int i=0;i<listr.size();i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(listr.get(j)==listr.get(i))
					listr.remove(i);
				
			}
			
		}
		System.out.println(listr);
		
	}

}
