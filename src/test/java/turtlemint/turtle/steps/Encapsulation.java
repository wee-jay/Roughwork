package turtlemint.turtle.steps;


class demo1 extends Encapsulation
{
	
	private String name;
	private int account_number, balance;
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	
	public void setBalance(int balance)
	{
		this.balance=balance;
	}
	
	public int getBalance()
	{
		return this.balance;
	}
	

}


public class Encapsulation {
	
	public static void main(String[] args) {
		demo1 ap = new demo1();
		ap.setName("Vijay");
		System.out.println(ap.getName());

	}


}
