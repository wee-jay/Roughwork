package turtlemint.turtle.steps;

public class MultiThreadconcept {

	public static void main(String[] args) throws InterruptedException {
		
		
		Runnable obj = () ->
				{
					for (int i=0;i<=5;i++)
					{
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Welcome "+"Priority of obj1 is : "+Thread.currentThread().getPriority());
					}
				};
		
		Runnable obj1 = () ->
				{
					for (int i=0; i<=5;i++)
					{
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("to the Jungle."+"Priority of obj2 is : "+Thread.currentThread().getPriority());
					}
				};
		
		Thread ob1 = new Thread(obj);
		Thread ob2 = new Thread(obj1);
		
		//ob1.join();
		//ob2.join();
		ob1.setPriority(4);
		ob2.setPriority(1);
		ob1.start();
		System.out.println(ob1.getName());
		System.out.println("Priority of obj1 is : "+ob1.getPriority());
		ob2.start();
		System.out.println(ob2.getName());
		System.out.println("Priority of obj2 is : "+ob2.getPriority());
	}

}
