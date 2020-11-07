package turtlemint.turtle.steps;


class overload 
{
	public void show ()
	{
		System.out.println("Show method called from overload class");
	}
}

class overloaded extends overload
{
	public void show ()
	{
		System.out.println("Child class Show method called from overloaded class");
	}
}


public class DynamicMethodDispatch {

	public static void main(String[] args) {
		overload a = new overloaded();
		a.show();
		a= new overload();
		a.show();
	}

}
