package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.List;

public class _18_GenericKSUM {
	// it is similar to Permutation in which how we changed states
	public static void main(String[] args) {
		
		int nums[]= {-2,-1,-1,1,1,2,2};
		//int nums[]= {-2,-1,0,0,1,2};
		fourSum(nums,0);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>>list=new ArrayList<>();
		
		System.out.println("ans "+kSum(nums,0,target,4));
		return list;
	}
	public static List<List<Integer>> kSum(int[]nums ,int start,int target,int k)
	{
		//System.out.println("k "+k+" target  "+target+" start "+start);
		if(k==2)
		{
			//call two sum
			return twoSum(nums,start,target);
		}
		List<List<Integer>>list=new ArrayList<>();
			for(int i=start;i<nums.length;i++)
			{
				System.out.println("k "+k+" target  "+target+" start "+start);
				if(i>start && nums[i-1]==nums[i])
					continue;
				List<List<Integer>>li=kSum(nums,i+1,target-nums[i],k-1);
				System.out.println("li "+li);
				for(List<Integer>a:li)
				{
					a.add(nums[i]);
				}
				
				System.out.println("------------------");
				list.addAll(li);
				System.out.println("list "+list);
			}
		
		//System.out.println("list "+list);
		return list;
	}
	
	 public static List<List<Integer>> twoSum(int[]nums,int start,int target)
		{
		 System.out.println("Two sum start "+target+" start "+start);
			List<List<Integer>>list=new ArrayList<>();
			int low=start;
			int high=nums.length-1;
			
			while(low<high)
			{
				//System.out.println("low "+low+" ,high "+high);
				int sum=nums[low]+nums[high];
				
				if(sum<target ||(low>start && nums[low-1]==nums[low]))
				{
					low++;
				}
				else if(sum>target || (high+1<nums.length && nums[high+1]==nums[high]))
				{
					high--;
				}
				else
				{
					
	                List<Integer>l=new ArrayList<>();
					l.add(nums[low]);
					l.add(nums[high]);
	               list.add(l);
	                	low++;
					high--;
					//found
				}
					
			}
			return list;
		}
	}


