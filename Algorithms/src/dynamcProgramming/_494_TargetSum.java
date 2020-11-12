package dynamcProgramming;

import java.util.Arrays;

public class _494_TargetSum {
	//similar to subset sum equal target problem 416
	public static void main(String[] args) {
		
		int nums[]= {1,2,1,3};
		
		findTargetSumWays1(nums,3);
	}
	 public static int findTargetSumWays1(int[] nums, int S) {
		 
		 //with using single dimensional dp array
		 int sum=0;
		 for(int i:nums)
		 {
			 sum+=i;
		 }
		 if((sum+S)%2!=0)
			return 0;
		 
		 int target=(sum+S)/2;
		 System.out.println("target "+target);
		 int dp[]=new int [target+1];
		 dp[0]=1;
		 for(int i=0;i<nums.length;i++)
		 {
			 for(int j=dp.length-1;j>=0;j--)
			 {
				 if(j-nums[i]>=0)
				dp[j]=dp[j-nums[i]]+dp[j];
			 }
			
		 }
		 System.out.println("ans "+dp[dp.length-1]);
	
		 
		 
		 return 0;
	 }
	
	 public static int findTargetSumWays(int[] nums, int S) {
		 //explained in notebook
		 //converting to subset sum equal target problem
		 //97%Fast	
		 //time -> n*target(calculated below)
		 int sum=0;
		 for(int i:nums)
		 {
			 sum+=i;
		 }
		 if((sum+S)%2!=0)
			return 0;
		 int target=(sum+S)/2;
		 System.out.println("target "+target);
		 int dp[][]=new int [nums.length+1][target+1];
		 dp[0][0]=1;
		 for(int i=1;i<dp.length;i++)
		 {
			 for(int j=0;j<dp[0].length;j++)
			 {
				 
				 if(j>=nums[i-1])
				 {
					int prev=dp[i-1][j-nums[i-1]];
					
					dp[i][j]=prev+dp[i-1][j];
				 }
				 else
				 {
					 dp[i][j]=dp[i-1][j];
				 }
				
			 }
			 traverse(dp[i]);
			 System.out.println("-----------------------");
		 }
		 System.out.println("ans "+dp[dp.length-1][dp[0].length-1]);
		 return dp[dp.length-1][dp[0].length-1];
	 }
	  public static void traverse(int a[])
	  {
		  for(int i:a)
		  {
			  System.out.print(i+" ");
		  }
		  System.out.println();
	  }
	
}
