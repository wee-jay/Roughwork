package turtlemint.turtle.steps;

import java.util.Scanner;

import org.apache.commons.math3.genetics.ElitisticListPopulation;

public class Printingpatterns {

	public static void main(String[] args) {
		
//		myprinter(5);
		pyrimad();
//		copiedpyramid();

	}
	
	public static void numberprinter()
	{
		final int b = 4;
		for(int i=1;i<=b;i++)
		{
			for(int j=1; j<=i; j++)
			{
				if(i==1)
				{
					System.out.print(i);
				}
			}
		}
	}
	
	public static void pyrimad()
	{
		int firs,secondinner,row=8;
		for(firs=1;firs<row;firs++)
		{
			for(secondinner=firs;secondinner<row;secondinner++)
			{
				System.out.print(" ");
			}
			for(secondinner=firs;secondinner<(firs*2);secondinner++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int k=1;k<row;k++)
		{
			System.out.print("  ");
			for(secondinner=k+1;secondinner<(k*2);secondinner++)
			{
				System.out.print(" ");
			}
			for(secondinner=k+1;secondinner<row;secondinner++)
			{
				System.out.print("* ");
			}
			
			
			System.out.println();
		}
	}
	
	
	public static void myprinter(int a)
	{
		for(int i = 1;i<=a;i++)
		{
			if(i==1 || i==a)
			{
				for (int j=1;j<=a;j++)
				{
					System.out.print("*");
				}
				System.out.print("\n");
			}
			else
			{
				System.out.print("*");	
				for (int j=1;j<=a;j++)
				{
					if (j==a-1)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");
					}
				}
				System.out.print("\n");
				
			}
			
		}
	}

}
