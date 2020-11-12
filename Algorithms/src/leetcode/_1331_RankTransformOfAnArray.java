package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _1331_RankTransformOfAnArray {
	
	public static void main(String[] args) {
		
		int arr[]= {40,10,20,30};
		arrayRankTransform(arr);
	}
	 public static int[] arrayRankTransform(int[] arr) {
		 int a[]=arr.clone();
		 Arrays.sort(a);
        
		  if(a.length==0)
	          return new int[]{};
		
		   HashMap<Integer,Integer>map=new HashMap<>();
		   int rank=1;
		   
		 /*  for(int i:a)
		   {
			  if(!map.containsKey(i))
			  {
				  map.put(i,rank);
				  rank++;
			  }			   
		   }*/
		   
		   //alter for this
		   for(int i:a)
		   {
			   map.putIfAbsent(i,map.size()+1);
		   }
		   for(int i=0;i<arr.length;i++)
		   {
			   arr[i]=map.get(arr[i]);
		   }
		   traverse(arr);
	        return arr;
	 }
	 
	 public static void traverse(int a[])
	 {
		 System.out.println();
		 for(int i:a)
			 System.out.print(i+" ");
		 System.out.println();
	 }

}
