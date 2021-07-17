package JavaConcepts.multiThreading.Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

class Resource1
{
	  volatile int  value;
	   public  void inc() throws InterruptedException
	{
		
		
		value++;
		System.out.println("Resource value after  "+value);
	}
}
public class VolatileExample {

	
	public static void main(String[] args) {
		
		final Resource1 r=new Resource1();
		
		
		Thread t1=new Thread(()-> {
			
			try {
				r.inc();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} );
		
		Thread t2=new Thread(()-> {
			
			try {
				r.inc();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} );
		//System.out.println("Resource value before  "+r.value);
		t1.setName("Thead 1 ");
		t2.setName("Thread 2");
		t1.start();
		t2.start();
		
		
	
	}
}
