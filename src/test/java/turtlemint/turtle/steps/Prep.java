package turtlemint.turtle.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;



public class Prep {

	public static void main(String[] args) {
		
		String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"aug", "Sep", "Oct", "nov", "Dec" };
		
		Arrays.sort(inputList);
		System.out.println("Aftersorting --> ");
		for(String e : inputList)
			System.out.print(e+", ");
		ArrayList <Integer> ar = new ArrayList<Integer>();
		
		for (int i=0; i<=10;i++)
		{
			ar.add(i);
		}
		
		for (int i=7; i<=21;i++)
		{
			ar.add(i);
		}
		
		System.out.println(ar);
		Set <Integer> uni = new HashSet<Integer>();
		Set <Integer> dubli = new HashSet<Integer>();
		for(int b : ar)
		{
			if (!uni.add(b))
			{
				dubli.add(b);
			}	
		}
		System.out.println("Using HasSet to print list of duplicate elements:-  \n"+dubli);

		List <Integer> data = ar.stream().distinct().collect(Collectors.toList());
		System.out.println("Using stream api to print distinct -->\n"+data);
		
//		<---------------->Program to print First two max value from an array<---------------->
		int arr []= {51,4,16,7,15,13,3,4,12,4};
		int maxone=0, maxtwo=0, maxthree=0; 
		for(int i=0; i<arr.length;i++)
		{
			if (maxone < arr[i]) {
				maxtwo = maxone;
				maxone = arr[i];
			} else 
				if (maxtwo < arr[i]) 
				{
					maxtwo = arr[i];
				}
		}
		System.out.println(maxone);
		System.out.println(maxtwo);
		
		
//		<---------------->Program to Remove extra spaces inside a string<---------------->
		String input = "Try    to    remove   extra   spaces.";
		StringBuffer sb = new StringBuffer();
		StringTokenizer substr = new StringTokenizer(input, " ");
		System.out.println(input);
		while(substr.hasMoreElements())
		{
			sb.append(substr.nextElement()).append(" ");
		}
		System.out.println(sb.toString().trim());
		
//		<---------------->Program to identify Palindrome number<---------------->
		int palindrome = 89108198;
		StringBuffer pal = new StringBuffer(String.valueOf(palindrome));
		pal.reverse();
		int paltest = Integer.parseInt(String.valueOf(pal));
		if(palindrome==paltest)
			System.out.println("Palindrome hai yeh.");
		else
			System.out.println("Palindrome nahi hai yeh.");
		
//		<---------------->Swap two integers/ strings without using temporary variable<---------------->
		int swap1 = 45, swap2 = 56;
		swap2=swap1+swap2;
		swap1=swap2-swap1;
		swap2=swap2-swap1;
		System.out.println(swap1+" "+swap2);
		
//		<---------------->Reverse string with string buffer<---------------->
		String rev1 = "Vijay Mahalingappa Bhangur";
		StringBuffer revs = new StringBuffer(rev1);
		revs.reverse();
		System.out.println(revs.toString());
		
		
//		<---------------->Reverse string with string buffer<---------------->
		String rev2="";
		for (int i =rev1.length()-1; i>=0;i--)
		{
			rev2=rev2+rev1.charAt(i);
		}
		System.out.println(rev2);
		
//		<---------------->Find odd and even number<---------------->
		int in = 222221, inw = 10;
		oddeven(inw);
		oddeven(in);
		counttotaldigits(inw);
		findoddandevendigits(in);
		
	}

//	<------------------>Count number of digits in given number<------------------>
	public static void counttotaldigits(int a)
	{
		int count=0; 
		while(a>0)
		{
			a=a/10;
			count++;
		}
		System.out.println("Total number of digits are > "+ count);
	}
	
//	<------------------>Find total odd and even digits in given number<------------------>
	public static void findoddandevendigits(int a)
	{
		int countodd=0, counteven=0; 
		while(a>0)
		{
			int temp = a%10;
			if(temp%2==0)
				counteven++;
			else
				countodd++;
			a=a/10;
		}
		System.out.println("Total number of odd digits are > " +countodd);
		System.out.println("Total number of even digits are > " +counteven);
	}
	
	
//	<------------------>Find given number is odd or even<------------------>
	public static void oddeven (int a)
	{
		if(a%2==0)
			System.out.println("Given number is even > " +a);
		else
			System.out.println("Given number is odd > " +a);
		
	}
	
	
	
//	<------------------>Invert / Reverse a number<------------------>
	public static long doInvert(long number) {

		long invert = 0;
		while (number != 0) {
			invert = (invert * 10) + (number % 10);
			number = number / 10;
		}
		return invert;
	}
	
//	<------------------>Find prime number logic<------------------>	
	public static boolean findPrimeCaseTest(int num)
	{
		if (num<=1)
			return false;
		else
			for(int i=2; i<=Math.sqrt(num);i++)
				if (num%i==0)
					return false;
		return true;
	}
}
