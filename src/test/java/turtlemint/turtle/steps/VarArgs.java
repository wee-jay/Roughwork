package turtlemint.turtle.steps;

public class VarArgs {

	public static void main(String[] args) {
		add obj = new add();
		System.out.println(obj.adding(3,0,3,4,5));
	}

}

class add {
//	Declaring var args with ...n when the number of variables are not consistent in count.
	public int adding (int ...n)
	{
		int sum = 0;
		for (int i : n)
		{
			sum+=i;
		}
		return sum;
	}
}