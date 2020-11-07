package turtlemint.turtle.steps;

public class SuperKeywordDemo {

	public static void main(String[] args) {
		Secondary sec = new Secondary();
		sec.demotesting();
	}

}

class Highest
{
	protected int high;
	public Highest ()
	{
		System.out.println("Highest class constructor called.");
	}
	
	public Highest (String a)
	{
		System.out.println("Parameterized Highest class constructor called.");
	}
	
	public static void callme(String a)
	{
		System.out.println("Static method of Highest class is called. "+a);
	}
	
	public static void main (String[] args)
	{
		System.out.println("Main class of Highest class called.");
	}
	
}

class Secondary extends Highest
{
	int second;
	public Secondary()
	{
/*		<-----------------------About super keyword----------------------->
 * 		Use super with parameter in case if we need super classes parameterized constructor to be called.
 * 		In case super keyword is not used it by default calls super class constructor,
 * 		not the overloaded / parameterized one.
 */
		super("Test");
		System.out.println("Secondary class constructor called.");
		super.callme("Called from constructor of child class");
	}
	public void demotesting()
	{
		System.out.println("Demo testing.");
		super.high=1;
		super.callme("Called from child class non-static method");
		super.callme("Called from child class non-static method 2nd time.");
		super.main(null);
	}
	
	
/*		<-----------------------Super keyword rules----------------------->
 * 	1. One can not use super keyword to call both normal and parameterized constructors
 *	   of super class at a time inside same class.
 * 	2. It can not be used outside the constructor of a child class.
 * 	3. Super keyword can be used to access variables of parent class.
 * 	4. Super keyword can not be used in static method.
 * 	5. You can call static and non-static methods using super keyword including main method.
 *  6. Using super keyword you can call any method of super class and 
 *     any number of times in same or different method of child class.
 *  7. You can not call private or final methods/variables of super class using super keywords.
 */
}
