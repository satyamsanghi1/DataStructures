package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _350_IntersectionOfTwoArraysII {
	
	public static void main(String[] args) {
		
		int nums1[]= {4,9,5};
		int nums2[]= {9,4,9,8,4};
		

       //Intersection(nums1, nums2);
		
		IntersectionSortedArrays();
	}

	public static void Intersection(int nums1[],int nums2[])
	{
		 ArrayList<Integer>ans=new ArrayList<Integer>();
	       HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	       
	       for(int i:nums1)
	       {
	           if(map.containsKey(i))
	           {
	               int value=map.get(i);
	               map.put(i,++value);
	           }
	           else
	               map.put(i,1);
	           
	       }
	       
	       for(int i:nums2)
	       {
	           if(map.containsKey(i))
	           {
	               int value=map.get(i);
	               if(value>0)
	               {
	               map.put(i,--value);
	               ans.add(i);
	               }
	           }
	           
	       }
	       System.out.println(ans);
	}

		public static void IntersectionSortedArrays()
		{
			/// if both the arrays are sorted
			
			int nums1[]= {1,1,2,2};
			int nums2[]= {2,2};
			
			
			int n1=nums1.length;
			int n2=nums2.length;
			int i=0,j=0;
		
			 ArrayList<Integer>ans=new ArrayList<Integer>();
			while(i<n1 && j<n2)
			{
				
				if(nums1[i]==nums2[j])
				{
					ans.add(nums1[i]);
					i++;j++;
				}
				else if(nums1[i]<nums2[j])
				{
					i++;
				}
				else if(nums2[j]<nums1[i])
				{
					j++;
				}
	
				
			}
			System.out.println("ans"+ans);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
}

