package leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class _1394_FindTheLuckyNumber {
	
	public static void main(String[] args) 
	{
		//int arr[]= {2,2,3,3,3};
		
		int arr[]= {5,17,14,16,13,1,4,17,1,1,1,6,19,3,17,20,12,8,18,7,17,12,10,14,4,2,14,20,15,6,19,12,8,16,20,18,3,11,2,2,17,9,1,4,15,20,15,15,16,18,2,10,18,18,7,10,11,4,9,6,14};
		//int ans=findLucky(arr);
		//System.out.println("ans "+ans);
		
		
		//int ans=findLuckyAlter(arr);
		//System.out.println("ans "+ans);
	
	}
	
	// speeed of radix sort is equal to hashmap
		
	  public static int findLuckyAlter(int[] arr) 
	  {
		  //99 % faster
		  
		  /// count the element at their respective indexes 
		  // check the element like counting sort
		  
		    int a[]=new int[501];
	        
	        for(int i:arr)
	            a[i]++;
	    
	        int max=-1;
	        for(int i=0;i<arr.length;i++)
	        {
	            if(arr[i]==a[arr[i]] )
	            {
	                if(max<a[arr[i]])
	                max=a[arr[i]];
	            }
	        }
			  return max;
		
	  }
	  
	  public static int findLucky(int[] arr) {
		  
		  //71 % faster
	        
	        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	        
	        for(int i=0;i<arr.length;i++)
	        {
	            if(map.containsKey(arr[i]))
	            {
	                int value=map.get(arr[i]);
	                map.put(arr[i],++value);
	            }
	            else
	                map.put(arr[i],1);
	        }
	        int max=-1;
	        for(Entry<Integer,Integer>e:map.entrySet())
	        {
	            if(e.getKey()==e.getValue())
	            {
	                if(e.getKey()>max)
	                {
	                    max=e.getKey();
	                }
	            }
	        }
	        return max;
	    }
	  
	  public static int[] countSort(int nums[])
	  {
		  	
			int arr[]=new int[501];
			int output[]=new int[nums.length];
			
			for(int i=0;i<nums.length;i++)
			{
				arr[nums[i]]++;
			}
			for(int p:arr)
				System.out.print(p+" ");
			System.out.println();
			for(int i=0;i<arr.length-1;i++)
			{
				arr[i+1]=arr[i]+arr[i+1];
			}
			
			for(int p:arr)
				System.out.print(p+" ");
			
			for(int i=0;i<nums.length;i++)
			{
				output[--arr[nums[i]]]=nums[i];
			}
			System.out.println();
			for(int p:output)
				System.out.print(p+" ");
			
			return output;
	  }
	  
	  public static int getMax(int nums[])
	  {
		  int max=0;
		  
		  for(int i:nums)
		  {
			  if(i>max)
				  max=i;
			  
		  }
		  return max;
	  }

}
