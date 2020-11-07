package turtlemint.turtle.steps;


public class StaticDemo {
	
	int Sal;
	String Name, Department, ReportingTo;
	static String Company; 
	
//	You can declare static block only inside a class
	static
	{
		Company="Turtlemint";
		System.out.println("Static block got executed.");
	}
	
	public StaticDemo()
	{
		System.out.println("Public class constructor called");
	}
	
	public StaticDemo(String s)
	{
		System.out.println("Parameterized public class constructor called");
	}
	static
	{
		Company="Neosoft Technologies";
		System.out.println("Static block got executed for second declaration.");
	}
	
	public void show()
	{
		System.out.println(Name+" : "+Department+" : "+ReportingTo+" : "+Sal+" : "+Company);
	}

	public static void main(String[] args) {
		StaticDemo obj1 = new StaticDemo();
		StaticDemo obj3 = new StaticDemo("test");
		
		obj1.Department="Technical";
		obj1.Name="Vijay Bhangur";
		obj1.Sal=40000;
		obj1.ReportingTo="Poorva";
		
		obj3.Department="Technical";
		obj3.Name="Ashish Pathak";
		obj3.Sal=45000;
		obj3.ReportingTo="Poorva";
		obj3.show();
		obj1.show();
		Company="Between";
		System.out.println("After modifying static variable comany name------->");
		obj3.show();
		obj1.show();
		test obj2 = new test();
		obj2.show();

	}

}

class test
{
	
	public test()
	{
		System.out.println("Inner test class constructor.");
	}
	public void show()
	{
		System.out.println("Show method from test class.");
	}
}
