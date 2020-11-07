package turtlemint.turtle.steps;

class Amain
{
	int c;
	public synchronized void count()
	{
		c++;
	}
}


public class Syncconcept {
	
	public static void main(String[] args) throws InterruptedException 
	{
		Amain a = new Amain();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0;i<=500;i++)
				{
					a.count();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0;i<=500;i++)
				{
					a.count();
				}
				
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(a.c);
	}

}
