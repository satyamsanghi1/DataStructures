package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.List;

public class _498_DiagonalTraverse {
	//also have algoexpert solution
	
	public static void main(String[] args) {
		
		int matrix[][]= {
						{ 1, 2, 3 },
						{4, 5, 6 },
						{ 7, 8, 9 }
						};
		
		findDiagonalOrder(matrix);
	}
	 public static int[] findDiagonalOrder(int[][] matrix) {
	        
		    // Write your code here.
        
		 int row=matrix.length;
		 int column=matrix[0].length;
	        int ans[]=new int [row*column];
	        ans[0]=matrix[0][0];
        int z=1;
		 int i=0;
		 int j=1;
		 boolean up=false;
		 if(row==1)
			{
			ans=matrix[0];
		 return ans;
			}
		 while(i!=row && j!=column)
		 {
			 if(up)
			 {
				 // go diagonally up
			while(i>=0 && j<column)
			 {
                ans[z]=matrix[i][j];
                z++;
			i--;
			j++;
			 }
                 i++	;
			if(j==column)
			{
				j--;
				i++;
			}
			up=false;
			 }
             // go diagonally down
			 else
			 {
				 while(j>=0 && i<row)
				 {
					 ans[z]=matrix[i][j];
                z++;
				 i++;
				 j--;
				 }
				 j++;
				 
				 if(i==row)
				 {
					 j++;
					 i--;
				 }	 
				 up=true;
			 }
		 }
		 traverse(ans);
		   return ans;
    }
	 
	 public static void traverse(int []ans)
	 {
		 for(int i:ans)
			 System.out.print(i+" ");
		 System.out.println();
	 }
}
