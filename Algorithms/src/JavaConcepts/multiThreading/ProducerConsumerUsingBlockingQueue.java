package JavaConcepts.multiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Integer>q=new ArrayBlockingQueue<Integer>(2);
		
		Thread producer=new Thread(()->
		{
			try {
				q.put(1);
				q.put(2);
				q.put(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				);
		
		Thread consumer=new Thread(()->
		{
			try {
				q.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				);
		
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
		System.out.println(q);
		
		
		
	}
}
