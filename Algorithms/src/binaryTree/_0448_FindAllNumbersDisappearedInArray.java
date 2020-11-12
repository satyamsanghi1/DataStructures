package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0448_FindAllNumbersDisappearedInArray {
	
	public static void main(String[] args) {
		
		int a[]= {4,3,2,7,8,2,3,1};
		
		//findDisappearedNumbers(a);
		
		alter(a);
	}
	public static void alter(int []nums)
	{
		// faster solution 
		
	// all the numbers in the array are index  so we iterate the array as index 
		// and mark element at that index as negative 
		
		
		List<Integer>list=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
		{
			System.out.println("er "+nums[i]);
			
			int index=Math.abs(nums[i])-1;
			System.out.println("index "+index);
			nums[index]=Math.abs(nums[index])*-1;
			
			System.out.println();
		}
		
		// the elements which are left positive
		//index at that positive value +1 is the no missing
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]>0)
				list.add(i+1);
		}
		System.out.println(list);
		traverse(nums);
	}
	public static void traverse(int a[])
	{
		for(int i:a)
			System.out.print(i + " ");
	}
	 public static  List<Integer> findDisappearedNumbers(int[] nums) {
		 
		 List<Integer>list=new ArrayList<Integer>();
		 
		 for(int i=1;i<=nums.length;i++)
		 {
			 list.add(i);
		 }
		 System.out.println(list);
		 for(int i=0;i<nums.length;i++)
		 {
			 
			 list.set(nums[i]-1,0);
			 //System.out.println(list);
		 }
		//list.removeAll(Arrays.asList(0));
		 
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)==0)
				nums[i]=0;
		}
		list.clear();
		for(int i:nums)
		 {
			 System.out.print(i+" ");
		 }
		 for(int i=0;i<nums.length;i++)
		 {
			 if(nums[i]!=0)
				 list.add(i+1);
		 }
		 
		 System.out.println();
		 System.out.println(list);
		// list.removeAll(Arrays.asList(0));
	
		/*
		 * for(int i=1;i<list.size();i++) { if(list.get(i)==1) list.remove(i); }
		 */
		 System.out.println(list);
		 return null;
	 }

}
