package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class _225_ImplementingStackUsingQueues {
	

	
	public static void main(String[] args) {
		
		
		MyStack1 m = new MyStack1();
		m.push(1);
	//	m.push(2);
	//	m.push(3);
		
		System.out.println(m.top());
		
		//System.out.println(m.pop());
		System.out.println(m.empty());
		

		 
	}

	
	  	

}
class MyStack1
{
	Queue<Integer>queue1=new LinkedList<>();
	Queue<Integer>queue2=new LinkedList<>();

	public  void push(int x)
  	{
		 queue1.add(x);    	
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public  int pop() 
    {
     if(!empty())
     {
    	 if(queue2.isEmpty())
    	 {

    			 int size=queue1.size();
    		 for(int i=0;i<size-1;i++)
    		 {
    			 System.out.println("polling queue1 "+queue1.peek());
    			 queue2.add(queue1.poll());
    		 }
    		 int x=queue1.poll();
 
    		 while(!queue2.isEmpty())
    		 {
    			 System.out.println("polling queue2 "+queue2.peek());
    			 queue1.add(queue2.poll());
    		 }
 
    		 return x;
   // 	 }
    	 }
    	
    	 else 
    		 return -1;
    	 
     }
     else
    	 return -1;
    
     
    }
    
    /** Get the top element. */
    public  int top()
    {
    	if(!empty()) {
    		 int size=queue1.size();
    		 
    	System.out.println("here size "+queue1.size());
		 for(int i=0;i<size-1;i++)
		 {
			 System.out.println("polling queue1 "+queue1.peek());
			 queue2.add(queue1.poll());
		 }
		 int x=queue1.poll();
		 queue2.add(x);

		 while(!queue2.isEmpty())
		 {
			 System.out.println("polling queue2 "+queue2.peek());
			 queue1.add(queue2.poll());
		 }

		 return x;
    	}
    	
    	return -1;
    }
    
    /** Returns whether the stack is empty. */
    public  boolean empty() 
    {
	     if(queue1.isEmpty() && queue2.isEmpty())
	    	 return true;
	     else 
	    	 return false;
    }
}
