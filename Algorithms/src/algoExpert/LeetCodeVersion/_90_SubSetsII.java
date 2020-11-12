package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _90_SubSetsII {
	
	/*
	 * Solution using hashset for removing duplicate subsets is very slow -18%
	 */
	public static void main(String[] args) {
		
		 int nums[]= {1,2,2};
			//subsetsWithDup(nums);
		 subsetsWithDupAlter(nums);
		
		
	}
	   public static List<List<Integer>> subsetsWithDup(int[] nums) {
	        
	       
	        List<List<Integer>>list=new ArrayList<>();
			list.add(new ArrayList<Integer>());
			List<Integer>current=new ArrayList<>();
			helper(0,nums,current,list);
			System.out.println(list);
	    return list;
	        
	    }
	  
	    
	   
	 public static void helper(int i,int []nums,List<Integer>current,List<List<Integer>>list)
		{
		 // 30% Fast
	          HashSet<Integer>set=new HashSet<Integer>();
			for(int k=i;k<nums.length;k++)
			{
	            if(!set.add(nums[k]))continue;
	            
			current.add(nums[k]);
				list.add(new ArrayList<Integer>(current));
				helper(k+1,nums,current,list);
				current.remove(current.size()-1);
			}
		}
	  public static List<List<Integer>> subsetsWithDupAlter(int[] nums) {
	        
		    
	        List<List<Integer>>list=new ArrayList<>();
			list.add(new ArrayList<Integer>());
			List<Integer>current=new ArrayList<>();
			boolean []used=new boolean[nums.length];
			
			helperAlter(0, nums,used, current, list);
			System.out.println(list);
	    return list;
	        
	    }
	 public static void helperAlter(int i,int []nums,boolean[] used,List<Integer>current,List<List<Integer>>list)
	 // 53%Fast
	 {
		 // using logic like permutations II 
		 // the only change  is that we are creating subsets with next index	
			for(int k=i;k<nums.length;k++)
			{
	            
	            if(used[k])
	            {	
	            	System.out.println("in");
	            	continue;
	            }
	         if(k>0 && !used[k-1] && nums[k-1]==nums[k])
	         {
	        	 System.out.println("here");
	        	 continue;
	         }
	            used[k]=true;
			current.add(nums[k]);
				list.add(new ArrayList<Integer>(current));
				helperAlter(k+1,nums,used,current,list);
				current.remove(current.size()-1);
				used[k]=false;
			}
		}

}
