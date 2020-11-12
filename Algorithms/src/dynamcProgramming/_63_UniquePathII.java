package dynamcProgramming;

public class _63_UniquePathII {
	
	 public static void main(String[] args) {
		
		 int [][] obstacleGrid= {{0,0,0},{0,0,0},{0,0,1}};
		 int ans=uniquePathsWithObstacles(obstacleGrid);
		 System.out.println("ans "+ans);
	}
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        
		 int dp[][]=new int [obstacleGrid.length][obstacleGrid[0].length];
		 
		 if(obstacleGrid[0][0]==1 || obstacleGrid[dp.length-1][dp[0].length-1]==1)
			 return 0;
		 
		 for(int i=0;i<obstacleGrid[0].length;i++)
		 {
			 if(obstacleGrid[0][i]==1)
				 break; 
			 dp[0][i]=1;
		 }
		 for(int i=0;i<obstacleGrid.length;i++)
		 {
			 if(obstacleGrid[i][0]==1)
				break;
			 dp[i][0]=1;
		 }
		 
		 for(int i=0;i<dp.length;i++)
		 {
			 for(int k=0;k<dp[0].length;k++)
			 {
				 if(obstacleGrid[i][k]==1)
				 {
					 dp[i][k]=Integer.MIN_VALUE;
				 }
			 }
		 }
		 
		 
		 for(int i=1;i<dp.length;i++)
		 {
			 for(int k=1;k<dp[0].length;k++)
			 {
				 if(dp[i][k]!=Integer.MIN_VALUE)
				 {
					 int up=dp[i-1][k];
					 int left=dp[i][k-1];
					 
					 if(up!=Integer.MIN_VALUE && left!=Integer.MIN_VALUE)
					 {
						 dp[i][k]=up+left;
					 }
					 else if(up==Integer.MIN_VALUE && left!=Integer.MIN_VALUE)
					 {
						 dp[i][k]=left;
					 }
					 else if(up!=Integer.MIN_VALUE && left==Integer.MIN_VALUE)
					 {
						 dp[i][k]=up;
					 }
				 }
			 }
		 }
		 return dp[dp.length-1][dp[0].length-1];
	    }
	 
	 

}
