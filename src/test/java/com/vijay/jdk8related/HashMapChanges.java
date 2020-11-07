package com.vijay.jdk8related;

import java.util.HashMap;
import java.util.Map;

public class HashMapChanges {

	public static void main(String[] args) {
		Map<String, Integer> ma = new HashMap<>();
		ma.put("Vijay", 100);
		ma.put("Amey", 100);
		
		System.out.println(ma.keySet());
		
		int p = 50;
		String sn = "Vijay";
		System.out.println("This is exiting format:--> \n"+p);
		StringBuffer s = new StringBuffer(String.valueOf(p));
		System.out.println("This is reversed format:--> \n"+s.reverse());
		
		
//		<------------------>Find reverse number<------------------>
		System.out.println(doInvert(p));
		
//		<------------------>Find prime number<------------------>
		System.out.println(findPrimeCaseTest(293));
		
	}
	
	
	public static long doInvert(long number) {

		long invert = 0;
		while (number != 0) {
			invert = (invert * 10) + (number % 10);
			number = number / 10;
		}
		return invert;
	}
	
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
