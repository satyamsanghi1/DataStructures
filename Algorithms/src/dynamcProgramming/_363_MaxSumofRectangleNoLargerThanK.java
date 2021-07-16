package dynamcProgramming;

import java.util.Arrays;

public class _363_MaxSumofRectangleNoLargerThanK {

	public static void main(String[] args) {

		//int matrix[][]= {{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};

		int matrix[][]= {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
		maxSumSubmatrix(matrix,8);
	}
	public static int maxSumSubmatrix(int[][] matrix, int k) {

		int l=0;
		int r=0;
		int curRect[]=new int[matrix.length];

		int currentSum=0;
		int maxSum=0;
		int maxUp=0;
		int maxDown=0;
		int maxLeft=0;
		int maxRight=0;

		while( l<matrix[0].length)
		{
			r=l;
			Arrays.fill(curRect,0);
			while(r<matrix[0].length)
			{
				System.out.println("r "+r);
				addToRect(matrix,r,curRect);
				int []val=kadane(curRect,k);
				
				currentSum=val[2];
				System.out.println("cur Rect Sum "+currentSum);
				if( currentSum>maxSum)
				{
					maxSum=currentSum;
					

					maxLeft=l;
					maxRight=r;
					maxUp=val[0];
					maxDown=val[1];
				}
				System.out.println("--------------max "+maxSum);
				r++;
			}
			System.out.println("_______________________________");
			l++;
		}
		
		System.out.println("bounds ");
		System.out.println("Left "+maxLeft);
		System.out.println("Right "+maxRight);
		System.out.println("up "+maxUp);
		System.out.println("down "+maxDown);
		System.out.println("max Sum "+maxSum);
		//System.out.println("final "+calFinalSum(matrix, maxUp, maxDown, maxLeft, maxRight));
		return maxSum;
	}
	public static int calFinalSum(int [][]matrix,int maxUp,int maxDown,int maxLeft,int maxRight)
	{
		int sum=0;
		for(int rowIdx=maxLeft;rowIdx<=maxRight;rowIdx++)
		{
			for(int colIdx=maxUp;colIdx<=maxDown;colIdx++)
			{
				sum+=matrix[rowIdx][colIdx];
			}
		}
		return sum;
	}

	public static void addToRect(int matrix[][],int r,int [] curRect)
	{
		for(int i=0;i<matrix.length;i++)
		{
			curRect[i]+=matrix[i][r];
		}
	}
	public static int[] kadane(int []col,int k)
	{
		int max=0;
		int current=0;
		int start=0;
		int curStart=0;//start of currentWindow

		int end=0;

		for(int i=0;i<col.length;i++)
		{
			current+=col[i];

			if(current<= k && current>max)
			{
				max=current;
				end=i;
				start=curStart;
			}

			if(current<0)
			{
				current=0;
				curStart=i+1;
			}
		}
		return new int []{start,end,max};
	}
}
