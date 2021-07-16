package dynamcProgramming;

public class _62_UniquePaths2 {
	//applying memoization 100%fast
	//algoexpert no ways to traverse graph
	//bottom up approach  time (N*M) space(N*M)
	public static void main(String[] args) {
		
	System.out.println(uniquePaths(3,4));	
	}
	  public static int uniquePaths(int m, int n) {
	        
	        int dp[][]=new int[m+1][n+1];
	      return  helper(1,1,m,n,dp);
	      
	    }
	    public static int helper(int i,int j,int m,int n,int [][]dp)
		{
	    	//first row or first column
			if(i==m || j==n)
	        {
				return 1;
			}
		
			if(dp[i][j]>0)
	            return dp[i][j];
	        
			int downWays=helper(i+1,j,m,n,dp);
			int rightWays=helper(i,j+1,m,n,dp);
	        
	        dp[i][j]=downWays+rightWays;
	        return dp[i][j];
		}
}
