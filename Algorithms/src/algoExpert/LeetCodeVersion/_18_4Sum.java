package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.List;

public class _18_4Sum {
	
	public static void main(String[] args) {
		
		//int nums[]= {-2,-1,-1,1,1,2,2};
		int nums[]= {-2,-1,0,0,1,2};
		fourSum(nums,0);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//twoSum(nums, 0, target);
		/*Every pointer should not come duplicate
		 * hence checking condition for duplicacy at every pointer
		 * there are four pointers : i,j,low,high
		 */
		
		List<List<Integer>>list=new ArrayList<>();
		
		for(int i=0;i<nums.length;i++)
		{
		if(i-1>=0 && nums[i-1]==nums[i])continue;
			for(int j=i+1;j<nums.length;j++)
			{
				if(j>i+1 && nums[j-1]==nums[j])
					continue;
				System.out.println("______________");
				System.out.println("a "+nums[i]+" b "+nums[j]);
				int sum=nums[i]+nums[j];
				int diff=target-sum;
				
				
				System.out.println("diff "+diff);
				twoSum(nums,j+1, diff,list,nums[i],nums[j]);
			}
			System.out.println("----------------------------");
		}
		System.out.println("ans "+list);
		return list;
		
	}
	 public static void twoSum(int[]nums,int start,int target,List<List<Integer>>list,int a,int b)
		{
			
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
					System.out.println("found");
	                List<Integer>l=new ArrayList<>();
					l.add(nums[low]);
					l.add(nums[high]);
	                l.add(a);
	                l.add(b);
	                list.add(l);
	                	low++;
					high--;
					//found
				}
					
			}
			
		}
	}


