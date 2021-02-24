package interview;

class Customer{

	int amount=10000;


	synchronized public void withdraw(int amount)
	{
		if(amount>this.amount)
		{
			System.out.println("insufficient amount");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("withdrawn completed");
		}
		this.amount-=amount;
	}

	synchronized public void deposit(int amount)
	{
		System.out.println("going to deposit..."); 
		this.amount+=amount;
		
		System.out.println("deposit completed... ");  
		notify();  
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}

public class InterThreadCommunication {

	public static void main(String[] args) {


		Customer c= new Customer();

		Thread t1=new Thread() {

			public void run()
			{
				System.out.println("hello");
				c.withdraw(15000);
			}
		};
		t1.start();
		
		
		
		new Thread() {

			public void run()
			{
				c.deposit(6000);
			}
		}.start();




	}

}
