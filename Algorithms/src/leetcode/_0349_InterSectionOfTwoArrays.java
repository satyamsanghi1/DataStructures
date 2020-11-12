package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class _0349_InterSectionOfTwoArrays {
	
	//FACEBOOK
	public static void main(String[] args) {
		
		
		int a[]= {9,4,8,9,4};
		int b[]= {4,9,5};
		
		alter(a,b);
		//intersection(a,b);
		
	}
	 public static int[] alter(int[] nums1, int[] nums2)
	 {
		 // 99 % FAST
		 HashSet<Integer>set=new HashSet<>();
		 
		 for(int i:nums1)
			 set.add(i);
		 
		 System.out.println("set1 "+set);
		 HashSet<Integer>set2=new HashSet<>();
		 
		 for(int i:nums2)
		 {
			if(set.contains(i))
				set2.add(i);
		 }
		 System.out.println("set2 "+set2);
		 
		 int[] x=new int[set2.size()];
		 
		 
		 int q=0;
		 for(int i:set2)
			 x[q++]=i;
		 
		 return x;
		
		  
	 }
	 public static int[] intersection(int[] nums1, int[] nums2)
	 {
		 // 44%Fast
		 HashMap<Integer,Integer>map=new HashMap<>();

		 for(int i=0;i<nums1.length;i++)
		 {
			 
			 if(!map.containsKey(nums1[i]))
			 {
				 map.put(nums1[i],1);
			 }
		 }
		 for(int i=0;i<nums2.length;i++)
		 {
			 
			 if(map.containsKey(nums2[i]))
			 {
				 int value=map.get(nums2[i]);
				 value--;
				 map.put(nums2[i],value);
			 }
		 }
		 ArrayList<Integer>list=new ArrayList<Integer>();
		 for(Entry<Integer,Integer>e:map.entrySet())
		 {
			 if(e.getValue()<=0)
			 {
				 System.out.println(e.getKey());
				 list.add(e.getKey());
			 }
			 }
		 int x[]=new int[list.size()];
		 int q=0;
		 for(int i:list)
			 x[q++]=i;
		 
		 	return x;
	 }
	
	
}
