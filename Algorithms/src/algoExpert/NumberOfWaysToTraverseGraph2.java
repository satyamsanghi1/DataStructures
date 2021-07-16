package algoExpert;

public class NumberOfWaysToTraverseGraph2 {
	//Leetcode 62 
	//algoexpert  time (N*M) space(N*M)
	// approach memoisation
	//bottom up approach is in dynamic package for leetcode question
	public static void main(String[] args) {

		
		System.out.println(numberOfWaysToTraverseGraph(4,3));
	}
	public static int numberOfWaysToTraverseGraph(int width, int height) {
		int dp[][]=new int [width+1][height+1];
		return helper(3,3,dp);
	}
	public static int helper(int m,int n,int dp[][])
	{
		//1 because not using 0-indexing
		//when first row and first column there is only one way 
		if(m==1 || n==1)
			return 1;
		
		if(dp[m][n]>0)
			return dp[m][n];


		//ways to reach current box is sum of ways if (above and left box) 
		dp[m][n]= helper(m-1,n,dp)+helper(m,n-1,dp);
		return dp[m][n];
	}

}
