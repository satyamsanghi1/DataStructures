package JavaConcepts.multiThreading;

import java.util.LinkedList;
import java.util.Queue;


 class BlockingQueue1<E>
{

	 private Queue<E> queue=new LinkedList<>();
	 private int limit=10;
	 
	 public BlockingQueue1(int limit)
	 {
		 this.limit=limit;
	 }
	 
	 public synchronized void insert(E item) throws InterruptedException
	 {
		 while(queue.size()==limit)
		 {
			 System.out.println("Full Size Reached ----");
			 wait();
		 }
		 queue.add(item);

			 notifyAll();
		 
	 }
	 
	 public synchronized E remove() throws InterruptedException
	 {
		 while(queue.size()==0)
		 {
			 System.out.println("queue is Empty");
			 wait();
		 }
		E e=queue.remove();
		notifyAll();
		
		return e;
	 }

	@Override
	public String toString() {
		return "BlockingQueue1 [queue=" + queue + "]";
	}
	 
}
public class ProducerConsumerWithoutBlockingQueue {

	
	
	public static void main(String[] args) throws Exception{
		
		BlockingQueue1<Integer> q=new BlockingQueue1<>(2);
	
		
		Thread producer=new Thread(()->
		{
			try {
				q.insert(1);
				q.insert(2);
				q.insert(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread consumer=new Thread(()->
		{
			try {
				q.remove();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
		System.out.println(q);
		
	}
}
