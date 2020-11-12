package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
	
	public static void main(String[] args) {
		
		int nums[]= {1,2,3};
			System.out.println(subsetsAlter(nums));
	}
	
	 public static List<List<Integer>> subsetsAlter(int[] nums) {
	        
	        List<List<Integer>>list=new ArrayList<>();
			list.add(new ArrayList<Integer>());
			for(int i=0;i<nums.length;i++)
			{	
				/*
				 * Everytime we are iterating with list of subsets  
				 * and adding the current elements with subsets present in the list	
				 */
				int size=list.size();
				for(int k=0;k<size;k++)
				{
					List<Integer>l=list.get(k);
					List<Integer>newList=new ArrayList<>(l);
					newList.add(nums[i]);
					list.add(newList);
					//System.out.println(list);
				}
			}
	    return list;
	        
	    }
	 
	//Used Logic like used in Permutations and recursion 
	 public static List<List<Integer>> subsets(int[] nums) {
	        
	        List<List<Integer>>list=new ArrayList<>();
			list.add(new ArrayList<Integer>());
			List<Integer>current=new ArrayList<>();
			helper(0,nums,current,list);
	    return list;
	        
	    }	
	 
	 public static void helper(int i,int []nums,List<Integer>current,List<List<Integer>>list)
		{
			for(int k=i;k<nums.length;k++)
			{
			current.add(nums[k]);
				list.add(new ArrayList<Integer>(current));
				helper(k+1,nums,current,list);
				current.remove(current.size()-1);
			}
		}

}
