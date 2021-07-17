package JavaConcepts.multiThreading.Synchronization;


class Resource
{
	 int value=0;
	  synchronized public  void inc() throws InterruptedException
	{
		
		for(int i=1;i<=10;i++) {
		value++;
		Thread.sleep(500);
		System.out.println("value "+value+" by "+Thread.currentThread().getName());
		}
	
	}
}
public class SynchronizationExample {

	
	public static void main(String[] args) {
		
		final Resource r=new Resource();
		
		
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
		
		
		System.out.println("Resource value after  "+r.value);
	}
}
