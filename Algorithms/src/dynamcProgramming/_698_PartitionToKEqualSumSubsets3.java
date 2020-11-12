package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*We can solve this problem recursively, we keep an array for sum of each partition
 *  and a boolean array to check whether an element is already taken into some partition or not.
 * 
 * 
 * 
 */
public class _698_PartitionToKEqualSumSubsets3 {
	
	public static void main(String[] args) {
		
		int nums[]= {2,1,4,5,3};
		
		boolean ans=canPartitionKSubsets(nums,3);
		System.out.println("ans "+ans);
	}
	 public static boolean canPartitionKSubsets(int[] nums, int k) {
	    
		 /*
		  * First we need to check some base cases,
			If K is 1, then we already have our answer,	
 			complete array is only subset with same sum.
			If N < K, then it is not possible to divide array into subsets with equal sum,
			 because we can’t divide the array into more than N parts.
			 
			 If sum of array is not divisible by K,
			  then it is not possible to divide the array. We will proceed only if k divides sum. 
		  */
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		 
		 System.out.println("total sum "+sum);
		 int eachSum=sum/k;
		 System.out.println("each sum "+eachSum);
		 if(k==1) //base case
			 return true;
		 
		 if(nums.length<k)  //base case
			 return false;
		 
		 if(sum%k!=0)	//base case
			 return false;
		 
		 /*In below code a recursive method is written which tries to add array element into some subset.
		  * If sum of this subset reaches required sum, we iterate for next part recursively,
		  *  otherwise we backtrack for different set of elements.
		  */
		 boolean ans=helper(nums,k,new boolean [nums.length],0,0,eachSum);
		return ans;
	    }
	 
	 public static boolean helper(int []nums,int k,boolean[]used,int index,int curSum,int target)
	 {
		 if(k==0)
		 {
			 return true;
		 }
		 
		 if(curSum==target)
		 {
			 //if we found a subset , then recursively call for next subset with used [] array	
			 return helper(nums,k-1,used,0,0,target);
		 }
		 for(int i=index;i<nums.length;i++) {
			 
			 /*used array is used to determine we dont duplicate 
			  * 
			  */
			 // if current element is not used and currentSum+nums is less than target 
			 //otherwise we cannot move after coming back from recursion we mark it again as false 
			 if(!used[i] && curSum+nums[i]<=target)
			 {
				 used[i]=true;
				 
				 if(helper(nums,k-1,used,0,curSum+nums[i],target))
					 return true;
				 
				 used[i]=false;
				 
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
