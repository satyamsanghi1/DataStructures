package LeetCode100;

import java.util.Arrays;

public class _300_LongestIncreasingSubSequence {

	//Leetcode 673 in leetcode package , no of longest increasing subsequence
	public static void main(String[] args) {
		
		int nums[]= {10,9,2,5,3,7,101,18};
		lengthOfLIS(nums);
		}
	
	 public static int lengthOfLIS(int[] nums) {
	// 72%fast (O)N^2

         int values[]=new int[nums.length];
		 int max=0;
		 int index=0;
        int min=Integer.MAX_VALUE;
		 for(int i=0;i<nums.length;i++)
		 {
			 //by default the current value at each index should be 1 
			 values[i]=1;
			 /*Finding the min num before the current index 
			  * and check if the current number is greater than min than only contnue
			  * else skip ,because if there is no min value behind there is no increasing 
			  * seubsequence exists behind that number
			  * 
			  */
			if(i-1>=0 &&  nums[i-1]<min)
                min=nums[i-1];
			
             if(nums[i]>min) // increasing speed by 10% , reducing comparisons
			 for(int j=0;j<i;j++)
			 {	
				 //if the value is less than current number than add dp value +1
				 //and check if its greater than current elements dp value
				 if(nums[j]<nums[i] )
				 {
					 
					 int x=values[j]+1;	
					 if(x>values[i])
					 {
						 values[i]=x;
					 }
				 }
			 }
             traverse(values);
			 max=Math.max(max,values[i]);
		 }
		 System.out.println("max "+max);
		 
		 return max;
	    }
	 public static int lengthOfLISAlter(int[] nums) {
		 //solution using binary search Time-> (O)NLogN
		 //not understood
		  int[] dp = new int[nums.length];
	        int len = 0;
	        for (int num : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, num);
	            if (i < 0) {
	                i = -(i + 1);
	            }
	            dp[i] = num;
	            if (i == len) {
	                len++;
	            }
	            traverse(dp);
	        }
	        return len;
	 }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }
}
