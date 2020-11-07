package turtlemint.turtle.steps;

import java.util.Scanner;

class hckrSeries{

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int p = 0;
            System.out.println("a: "+ a +"\nb: "+b+"\nn: "+n);
            for(int j=0; j != n; ++j) 
            {
            	int o = (int) Math.pow(2, j);
                System.out.println("2  to the power of " +j+" is : "+ o);
                p += o*b;
                System.out.println("Value of P is "+ (p + a));
                
            }
            System.out.print("\n");
            
        }
        in.close();
    }
}

