package slidingWindow;

public class MaxAvgOfSubArrayofSizeK {
	
	//LEETCODE  643
	
	/*
	 *  Given an array consisting of n integers, 
	 *  find the contiguous subarray of given length k that has the maximum average value. 
	 *  And you need to output the maximum average value.
	 * 
	 */

	public static void main(String[] args) {
		
		int nums[]= {4,2,1,7,8,1,2,8,1,0};
		
		maxAvgSubarray(nums,3);
	}
	
	public static double maxAvgSubarray(int nums[],int k)
	{		
		double maxAvg=Integer.MIN_VALUE;
		int currentRunningSum=0;
		
		for(int i=0;i<nums.length;i++)
		{
						
			
				currentRunningSum+=nums[i];
	
			if(i>=k-1) {
				//instead of calculating avg here find avg when returning 
				// just find max sum
			double avg=(double)currentRunningSum/k;
				System.out.println("current "+avg);
			maxAvg=Math.max(avg,maxAvg);
			System.out.println("i "+i);
			currentRunningSum-=nums[i-(k-1)];
			}
		}
		System.out.println("max "+maxAvg);
		return maxAvg;
	}
}
