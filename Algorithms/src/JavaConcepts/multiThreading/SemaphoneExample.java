package JavaConcepts.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Task implements Runnable
{
	Semaphore s;

	public Task(Semaphore s)
	{
		this.s=s;
	}
	public void run()  
	{
		//only 3 thread can acces at a time
		try {

			s.acquire();
			System.out.println("available permits"+s.availablePermits());
			System.out.println(Thread.currentThread().getName());
			for(int i=0;i<5;i++)
			{
				System.out.print(i);
				Thread.sleep(2000);
			}
				System.out.println();
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				s.release();
				System.out.println("after release "+s.availablePermits());
			}

		}
	}

	public class SemaphoneExample {



		public static void main(String[] args) {

			Semaphore semaphore=new Semaphore(2);

			ExecutorService service=Executors.newFixedThreadPool(20);
			Task t=new Task(semaphore);
			for(int i=0;i<10;i++)
				service.execute(t);

			service.shutdown();
		}
	}
