package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _698_PartitionToKEqualSumSubsets2 {
	
	public static void main(String[] args) {
		
		int nums[]= {2,1,4,5,3,3};
		
		boolean ans=canPartitionKSubsets(nums,3);
		System.out.println("ans "+ans);
	}
	 public static boolean canPartitionKSubsets(int[] nums, int k) {
	    
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		 
		 System.out.println("total sum "+sum);
		 int eachSum=sum/k;
		 System.out.println("each sum "+eachSum);
		 
		
		 return canPartitionKSubsetsFrom(nums, k, new boolean[nums.length], sum / k, 0, 0); 
	
	    }
	 private static boolean canPartitionKSubsetsFrom(int[] nums, int k, boolean[] visited, 
             int targetSubsetSum, 
             int curSubsetSum, 
             int nextIndexToCheck) {
		 
		 if (k == 0) {
	            return true;
	        }
		 
		  if (curSubsetSum == targetSubsetSum) {
			  traverse1(visited);
			  System.out.println("here");
	            return canPartitionKSubsetsFrom(nums, k - 1, visited, targetSubsetSum,0,0);
	        
	        }
		  System.out.println("k "+k+" curSum "+ curSubsetSum);
		  for (int i = nextIndexToCheck; i < nums.length; i++) {
			  System.out.println("i "+i);
			  traverse1(visited);
	            if (!visited[i] && curSubsetSum + nums[i] <= targetSubsetSum) {
	                visited[i] = true;
	                System.out.println("---------------------------------------");
	                if (canPartitionKSubsetsFrom(nums, 
	                                             k,
	                                             visited,
	                                             targetSubsetSum,
	                                             curSubsetSum + nums[i],
	                                             i + 1)) {
	                    return true;
	                }
	                System.out.println("k "+k+" curSum "+ curSubsetSum);
	                visited[i] = false;
	            }
	        }
	        
	        return false;
		 
		 
	 }
	
	 
	 public static void traverse1(boolean dp[])
	  {
		  for(boolean i:dp)
		  {
			  if(i)
					 System.out.print("T");
				 else
					 System.out.print("F");
		  }
		  System.out.println();
	  }

}
