package dynamcProgramming;

import java.util.Arrays;

public class _764_LargestPlusSign2 {
	//low complexity 
	public static void main(String[] args) {
//https://leetcode.com/problems/largest-plus-sign/discuss/113314/JavaC++Python-O(N2)-solution-using-only-one-grid-matrix/114381

		int N=5;
		int [][]mines=new int[][] {{4,2}};
		Long start=System.currentTimeMillis();

		int ans=orderOfLargestPlusSign(N, mines);
		System.out.println("ans "+ans);
		Long end=System.currentTimeMillis();
		System.out.println("start "+start+ " end "+end);
		System.out.println("time taken "+(end-start));

	}
	
	
	public static int orderOfLargestPlusSign(int N, int[][] mines) {

		int[][] grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(grid[i], N);
		}

		for (int[] m : mines) {
			grid[m[0]][m[1]] = 0;
		}
		traverse(grid);
		System.out.println("----------------------------------");

		for (int i = 0; i < N; i++) {

			System.out.println("i "+i);
			for (int j=0, l=0; j < N; j++) {
				// j is a column index, iterate from left to right
				// every time check how far left it can reach.
				// if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment
				grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
			}
			traverse(grid);
			System.out.println("_____________");
			for (int k = N-1, r=0; k >= 0; k--) {
				// k is a column index, iterate from right to left
				// every time check how far right it can reach.
				// if grid[i][k] is 0, r needs to start over from 0 again, otherwise increment
				grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
				
			}
			traverse(grid);
			System.out.println("_____________");
			for (int j = 0, u=0; j < N; j++) {
				// j is a row index, iterate from top to bottom
				// every time check how far up it can reach.
				// if grid[j][i] is 0, u needs to start over from 0 again, otherwise increment
				grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
			}
			traverse(grid);
			System.out.println("_____________");
			for (int k = N-1, d=0; k >= 0; k--) {
				// k is a row index, iterate from bottom to top
				// every time check how far down it can reach.
				// if grid[k][i] is 0, d needs to start over from 0 again, otherwise increment
				grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
			}
			traverse(grid);
			System.out.println("_____________");
			// after four loops each time taking Math.min over the grid value itself
			// all grid values will eventually take the min of the 4 direcitons.
			System.out.println("---------------");
		}


		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res = Math.max(res, grid[i][j]);
			}
		}

		return res;
	}
	
	public static void traverse(int [][]grid)
	{
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}





}
