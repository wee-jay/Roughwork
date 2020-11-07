package turtlemint.turtle.steps;



public class Factorial {
	
	public static void factorial(double N)
	{
		if (N == 0)
		{
			System.out.println("Factorial of given number is : 1");
		}
		else 
		{
			if (N>=1)
			{
				for(double i =N; i>1; i--)
				{
					N = N * (i-1);
				}
				System.out.println("Factorial  is : "+N);
				
			}
		}
		
	}

	public static void main(String[] args) 
	{
		Factorial.factorial(6);
		
		int o = (int) (Math.pow(2, 3));
		System.out.println(o);
	}

}
