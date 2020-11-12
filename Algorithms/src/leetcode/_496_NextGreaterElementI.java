package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class _496_NextGreaterElementI {

	/*
	 * REFERENCE - https://www.youtube.com/watch?v=uFso48YRRao - Algorithm EVeryDay 
	 * 
	 * https://www.youtube.com/watch?v=8BDKB2yuGyg -> nick white
	 * 
	 */
	public static void main(String[] args) {
		
		int []nums1 = {2,4};
		int []nums2 = {1,2,3,4};
		nextGreaterElement(nums1, nums2);
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		// ideal solution 
		// less faster(82%) than my solution
		 int x[]=new int[nums1.length];
		 if(nums1.length==0 || nums2.length==0)
	            return x;	
		 HashMap<Integer,Integer>map=new HashMap<>();
		 Stack<Integer>stack=new Stack<>();
		 stack.push(nums2[0]);
		 for(int i=1;i<nums2.length;i++)
		 {
			 while( !stack.isEmpty() &&nums2[i]>stack.peek())
			 {
				 System.out.println("next greater for "+stack.peek()+" is "+nums2[i]);
				 map.put(stack.peek(),nums2[i]);	
				 stack.pop();
			 }
			 
				 stack.push(nums2[i]);
			 
		 }
		 for(int i=0;i<nums1.length;i++)
		 {
			x[i]=map.getOrDefault(nums1[i],-1);
		 }
		 traverse(x);
		 return x;
	}
	public static int[] nextGreaterElementMySolution(int[] nums1, int[] nums2) {
		//my solution
		// 98 % Faster
		 int x[]=new int[nums1.length];
		 HashMap<Integer,Integer>map=new HashMap<>();
		 
		 for(int i=0;i<nums2.length;i++)
		 {
			 map.put(nums2[i],i);
		 }
		 /*
		  * 
		  * Step 1 : storing the elements of nums2 in hashmap and their index 
		  * Step 2 : iterating nums1 :
		  * 		if nums1[i] is in map than we can get the index in 0(1) time 
		  * 		after that we can iterate till end of nums2 to find greatest from that no
		  */
		 for(int i=0;i<nums1.length;i++)
	        {
			 if(map.containsKey(nums1[i]))
			 {
				 int index=map.get(nums1[i]);
				 System.out.println("index "+index);
				 int z=index+1;
		           while(z<nums2.length)
		           {
		        	   if(nums2[z]>nums1[i])
		        	   {
		        		   System.out.println("greater "+nums2[z]);
		        		   x[i]=nums2[z];
		        		   
		        		   break;
		        	   }
		        	   z++;
		           }
		           if(z==nums2.length)
		           {
		        	   x[i]=-1;
		           }
		        
			 }
			 
	        }
		 traverse(x);
		 return x;
	}
	 public static int[] nextGreaterElementAlter(int[] nums1, int[] nums2) {
		 // very slow solution 
	        
		 int x[]=new int[nums1.length];
	        for(int i=0;i<nums1.length;i++)
	        {
	        	boolean flag=false;
	        for(int k=0;k<nums2.length;k++)
	        {
	            if(nums2[k]==nums1[i])
	            {
	            	System.out.println("found "+nums1[i]+"at k "+k);
	            	int z=k+1;
	           while(z<nums2.length)
	           {
	        	   System.out.println("in while");
	        	   if(nums2[z]>nums1[i])
	        	   {
	        		   System.out.println("greater "+nums2[z]);
	        		   x[i]=nums2[z];
	        		   flag=true;
	        		   break;
	        	   }
	        		   
	        		   z++;
	           }
	           if(flag==true)
	           break;
	               
	            }
	                else
	                    x[i]=-1;
	            }
	           System.out.println();
	            
	        }
	        traverse(x);
	        
	     
	        return x;
	    }
	 public static void traverse(int a[])
	 {
		 
		 for(int i:a)
			 System.out.print(i+" ");
		 System.out.println();
	 }
}
