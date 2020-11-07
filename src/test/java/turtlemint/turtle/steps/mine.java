package turtlemint.turtle.steps;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class mine {


	public static void main(String[] args) 
	{
		
		String name = "Attribute";
		char temp;
		int ant=0;
		
		for(int i = 0; i<= name.length()-1;i++)
		{
			temp = name.charAt(i);
			if (Character.isUpperCase(temp))
			{
				System.out.println("This is Upper case letter: "+temp);
				ant++;
			}
			
			
		}
		System.out.println(ant);
		
//		String []coverAmountValues= {
//				"	1 year", "	2 years", "	3 years", "	4 years", "	5 years", "	6 years", "	7 years", "	8 years", "	9 years", "	10 years", "	11 years", "	12 years", "	13 years", "	14 years", "	15 years", "	16 years", "	17 years", "	18 years", "	19 years", "	20 years", "	21 years", "	22 years", "	23 years", "	24 years", "	25 years", "	26 years", "	27 years", "	28 years", "	29 years", "	30 years", "	31 years", "	32 years", "	33 years", "	34 years", "	35 years", "	36 years", "	37 years", "	38 years", "	39 years", "	40 years", "	41 years", "	42 years", "	43 years", "	44 years", "	45 years", "	46 years", "	47 years", "	48 years", "	49 years", "	50 years", "	51 years", "	52 years", "	53 years", "	54 years", "	55 years", "	56 years", "	57 years", "	58 years", "	59 years", "	60 years", "	61 years", "	62 years", "	63 years", "	64 years", "	65 years", "	66 years", "	67 years", "	68 years", "	69 years", "	70 years", "	71 years", "	72 years", "	73 years", "	74 years", "	75 years", "	76 years", "	77 years", "	78 years", "	79 years", "	80 years", "	81 years", "	82 years", "	83 years", "	84 years", "	85 years", "	86 years", "	87 years", "	88 years", "	89 years", "	90 years", "	91 years", "	92 years", "	93 years", "	94 years", "	95 years", "	96 years", "	97 years", "	98 years", "	99 years", "	100 years",
//		                             		};
//		for (int i =0; i<=coverAmountValues.length; i++)
//		{
//			System.out.println("\""+coverAmountValues[i].toString().trim()+"\",");
//		}
		
//		String s = new String("Vijay");
//		String b = "Vijay";
//		System.out.println(s==b);
//		System.out.println(s.equals(b));
//		System.out.println(s.intern()==b.intern());
//		
//		int year = 1742, day = 11, month = 12;
//		
//		if (year>=1600)
//		{
//			int test = year%4;
//			System.out.println(test);
//			if (test==0)
//			{
//				System.out.println("It is a Leap year! :) ");
//			}
//			
//			else
//			{
//				System.out.println("It is not a Leap year. :( ");
//			}
//		}
/*		--------------------Reverse String program--------------------
		String name = "Vijay Mahalingapp Bhangur";
		String li[] = name.split(" ");
		for (int i=0; i<=li.length-1; i++)
			{
				String car = name.split(" ")[i];
				System.out.print(" ");
				for(int j=car.length()-1;j>=0;j--)
				{
					System.out.print(car.charAt(j));
				}
			}
		--------------------Reverse String program--------------------
*/	
		
		String amen = "Vijay", bomen = "Amey";
		
		amen=amen+bomen;
		bomen=amen+bomen;
		
		System.out.println(amen +" ---- "+bomen);
		
/*		--------------------Reverse Integer program--------------------
		int a = 14456782, rev = 0;
		while(a!=0)
		{
			rev = a%10+rev*10;
			a = a/10;
		}
		System.out.println(rev);
		System.out.println(new StringBuffer(String.valueOf(rev)).reverse());
		--------------------Reverse Integer program--------------------
*/
		
/*		--------------------Finding duplicate values--------------------

// First method also considered as worst as per big 'O' notation
		String subjects[]= {"Chemistry", "Physics", "Biology", "Env", "Mathematics", "Physics"};
		
		for(int i=0; i<=subjects.length-1;i++)
		{
			for (int j=i+1; j<=subjects.length-1; j++)
			{
				if(subjects[i]==subjects[j])
				{
					System.out.println("Duplicate subject found named > "+ subjects[i]);
				}
			}
		}
		
//		Second method considered as much better than above one. It uses HashSet
		
		Set<String> hel = new HashSet<String>(); 
		for(int i=0; i<=subjects.length-1;i++)
		{
			if(hel.add(subjects[i])==false)
			{
				System.out.println("This is a duplicate subject > "+ subjects[i]);
			}
		}
		
//		Third method is also considered better than 1st one. It uses HashMap

		Map<String, Integer> strint = new HashMap<String, Integer>(); 
		
		for(String name : subjects)
		{
			Integer counter = strint.get(name);
			if (counter == null)
			{
				strint.put(name, 1);	
			}
			
			else
			{
				strint.put(name, ++counter);
			}
		}
		
		Set<Entry<String, Integer>> atlast = strint.entrySet();
		for(Entry<String, Integer> lis :atlast)
		{
			if(lis.getValue()>1)
			{
				System.out.println("This is that dublicate element : "+lis.getKey());
			}
		}	
		
		--------------------Finding duplicate values--------------------
*/

//		--------------------Finding Largest and Smallest value in list--------------------
		int a []= {1, 13, 3, 5, 12, 78, 153, 1223,45}, lowest, largest;
		lowest = a[0];
		largest = a[0];
		
		for(int i=0;i<=a.length-1;i++)
		{
			if (lowest>a[i])
			{
				lowest = a[i];
			}
			if(largest <a[i])
			{
				largest = a[i];
			}
		}
		int lowest2 = lowest+1;
		for(int i=0;i<=a.length-1;i++)
		{
			if(a[i]==lowest)
			{
				System.out.println("ignoring");
			}
			else
			{
				if (lowest2>a[i])
				{
					lowest2=a[i];	
				}
				
				
			}
		}
		
		System.out.println("This is the smallest number: "+lowest);
		System.out.println("This is the 2nd smallest number: "+lowest2);
		System.out.println("This is the biggest number: "+largest);
		
//		--------------------Finding Largest and Smallest value in list--------------------
//*/		
/*		--------------------Swap two integers using XOR '^' operator--------------------
		int a = 1, b = 30;
		a = a ^b;
		b = a ^b;
		a = a ^b;		
		System.out.println(a);
		System.out.println(b);

//		--------------------Swap two integers using '/' operator--------------------
		a = a*b;
		b = a/b;
		a = a/b;
		System.out.println(a);
		System.out.println(b);
		--------------------Swap two integers using '/' operator--------------------
*/		

		
		
	}

}
