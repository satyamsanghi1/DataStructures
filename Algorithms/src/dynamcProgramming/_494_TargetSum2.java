package dynamcProgramming;



public class _494_TargetSum2 {
	//similar to subset sum equal target problem 416
	
	public static void main(String[] args) {
		
		int nums[]= {1,2,1,3};
		
		findTargetSumWays(nums,3);
	}

	
	 public static int findTargetSumWays(int[] nums, int S) {
		
		 //approach 2
		 //not working
		 int sum=0;
		 for(int i:nums)
		 {
			 sum+=i;
		 }
		 
		 int dp[][]=new int [nums.length+1][2*S+1];
		 dp[0][S]=1;
		 for(int i=1;i<dp.length;i++)
		 {
			 for(int j=-S;j<=S;j++)
			 {
				if(j<=0) 
				 dp[i][j+S]+=dp[i-1][j+S+nums[i-1]];
				else
				 dp[i][j]+=dp[i-1][j-nums[i-1]];
			 }
			 System.out.println("---------------");
		 }
		 System.out.println("ans "+dp[dp.length-1][dp[0].length-1]);
	
		 return 0;
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
