package slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _0239_SlidingWindowMaximum {

	public static void main(String[] args) {
		
		int nums[]= {1,3,-1,-3,5,3,6,7};
		
		maxSlidingWindow(nums,3);
		
	}
	 public static int[] maxSlidingWindow(int[] nums, int k)
	 {
		 /// solve with dequeue
	     Queue<Integer>queue=new LinkedList<Integer>();
	     
	     ArrayList<Integer>list=new ArrayList<Integer>();
	     System.out.println("length "+nums.length);
	     for(int i=0;i<k;i++)
	     {
	    	 queue.add(nums[i]);
	     }
	        //System.out.println(Collections.max(queue));
		 list.add(Collections.max(queue));
	      //  System.out.println(list);
		 //System.out.println(queue.poll());
	        for(int i=k;i<nums.length;i++)
	        {
	        	queue.poll();
	        	queue.add(nums[i]);
	        	list.add(Collections.max(queue));
	        	System.out.println(Collections.max(queue));
	        }
	        System.out.println(list);
		 return null;
	    }
	 
}
