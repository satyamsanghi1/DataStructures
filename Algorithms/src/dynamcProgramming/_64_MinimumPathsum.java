package dynamcProgramming;

public class _64_MinimumPathsum {
	
	public static void main(String[] args) {
		
		
		int grid[][]= {{1,2,5},
					{3,2,1},
							};
		minPathSum(grid);
		
	}
	 public	static int minPathSum(int[][] grid) {
	        //90%,50%	
		int dp[][]=new int[grid.length][grid[0].length];
		dp[0][0]=grid[0][0];
			//base case for first row
		for(int i=1;i<dp[0].length;i++)
		{
			dp[0][i]=dp[0][i-1]+grid[0][i];
			System.out.print(" "+dp[0][i]+" ");
		}
		System.out.println();
		for(int i=1;i<dp.length;i++)
		{
			dp[i][0]=dp[i-1][0]+grid[i][0];
			System.out.println(" "+dp[i][0]);
		}
		
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				System.out.print(" "+grid[i][j]+" ");
				int up=0,left=0;
				
				 left=dp[i][j-1];
			
				up=dp[i-1][j];
				
				dp[i][j]=Math.min(up,left)+grid[i][j];
				System.out.print("up "+up+",left "+left+" val : "+dp[i][j]+":-:");
				
				
			}
			System.out.println();
		}
		
		 return 0;
	    }

}
