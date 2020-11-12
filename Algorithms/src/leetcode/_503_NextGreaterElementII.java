package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class _503_NextGreaterElementII {
	// video reference : 	https://www.youtube.com/watch?v=ARkl69eBzhY ->Nick White
	public static void main(String[] args) {
		
		
		int nums[]= {1,2,1};
		nextGreaterElements(nums);
		
	}
	public  static int[] nextGreaterElements(int[] nums) {
		 int n=nums.length;
		 int ans[]=new int[n];
		 // filling the output array by -1, default so that if thhere
		 // is not greater element the value would be -1 by default 
		 Arrays.fill(ans,-1);
		 Stack<Integer>stack=new Stack<>();	
		 for(int i=0;i<2*n;i++)
		 {
			 
			 //i%n beacuse , when i will become greater than n
			 // moduls will help in reiterating the array
			 while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n])
			 {
				 ans[stack.pop()]=nums[i%n];
			 }
			 /*
			  * Pushing only elements till n , since after n we just have to recheck the elements
			  * again we the stack remaining values  
			  */
			 if(i<n)
				 stack.push(i);
			 
			 traverse(ans);
		 }
		
	
		return ans;
	}
	public  static int[] nextGreaterElements1(int[] nums) {
		
		//20%Fast 
		/*
		 * 
		 * We dont require a hashmap , since we are storing index values in stack 
		 * hence we can direct assign greater value (if present) to that index value
		 */
		
		   int ans[]=new int[nums.length]; 
		   Arrays.fill(ans,-1);
		   
		   // duplication created array slows down the solution 
		   int a[]=new int[2*nums.length];
		   a[0]=nums[0];
		   for(int i=1;i<a.length;i++)
		   {
			   a[i]=nums[i%(nums.length)];
			   
		   }
			
	        Stack<Integer>stack=new Stack<>();
	        
	        for(int i=0;i<a.length;i++)
	        {
	        	while(!stack.isEmpty() && a[stack.peek()]<a[i])
	        	{
	        		//map.put(stack.pop(),a[i]);
	        		int index=stack.pop();
	        		if(index<nums.length)
	        		ans[index]=a[i];
	        	}
	        	stack.push(i);
	        }
	        traverse(ans);
	        for(int i=0;i<nums.length;i++)
	        {
	        	
	        	if(ans[i]==Integer.MIN_VALUE)
	        		ans[i]=-1;
	        	//ans[i]=-1;
	        }
	
	        System.out.println("ans ");
	        traverse(ans);
		   traverse(a);
		 
		   return ans;
	}
	public  static int[] nextGreaterElementsAlter(int[] nums) {
		//30% Fast
		   int ans[]=new int[nums.length]; 
	
		int max=Integer.MIN_VALUE;
		for(int k:nums)
		{
			max=Math.max(k,max);
		}
		/*
		 * finding the max value , so that we can check in future for elements  will they have any 
		 * greater element by comparing with the maximum
		 */
			
	        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	        
	        Stack<Integer>stack=new Stack<>();
	        
	        int i=1;
	        stack.push(0);
	        while(!stack.isEmpty()&& map.size()!=nums.length)
	        {
	        
	        	System.out.println(i);
	            while(!stack.isEmpty() && nums[i]>nums[stack.peek()])
	            {
	                map.put(stack.peek(),nums[i]);
	               
	                System.out.println("here "+ stack.pop());
	               
	            }
	            /*
	             * Using the max value for this condition
	             * if element at top of stack is >= max
	             * then pop it , and mark its greater as -1 in the map
	             */
	            if(!stack.isEmpty() &&nums[stack.peek()]>=max)
	            {
	            	System.out.println("in ");
	            	map.put(stack.pop(),-1);
	            }
	           
			
	            stack.push(i);
	            i++;
	            
	            if(i==nums.length)
	                i=0;
	            System.out.println("end");
	           traverseMap(map);
	           System.out.println("stack "+stack);
	           System.out.println();
	            
	        }
	     
	      
	       for(int k=0;k<nums.length;k++)
	        {
	        ans[k]=map.get(k);
	        }
	        traverse(ans);
	     
	        System.out.println("ans ");
	        traverseMap(map);
	        return ans;
	        
	    }
	
	public static void traverse(int nums[])
	{
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void traverseMap(HashMap<Integer,Integer>map)
	{
		for(Entry<Integer,Integer>e:map.entrySet())
		{
			System.out.println(e.getKey()+" , "+e.getValue());
		}
	}

}
