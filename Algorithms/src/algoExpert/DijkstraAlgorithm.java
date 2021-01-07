package algoExpert;

import java.util.Arrays;

public class DijkstraAlgorithm {
	
	public static void main(String[] args) {
		//my solution DFS has large time complexity , visiting every node
	
		int [][][]edges=new int [][][] {
		    {{1, 3}, {2, 2}},
		    {{3, 7}},
		    {{1, 2}, {3, 4}, {4, 1}},
		    {},
		    {{0, 2}, {1, 8}, {3, 1}}
		  };
				
		
		int ans[]=dijkstrasAlgorithm(4, edges);
		System.out.println("ans ");
		for(int i:ans)
		{
			System.out.print(i+" ");
		}
		
	}
	 public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		    // Write your code here.
		 
		 //Recursion + backtracking
		 System.out.println(edges.length);
		 
		 int matrix[][]=new int [edges.length][edges.length];
		 boolean seen[][]=new boolean [edges.length][edges.length];
		 for(int i=0;i<edges.length;i++)
		 {
			 for(int k=0;k<edges[i].length;k++)
			 {
				 if(edges[i][k].length>0)
				 {
					 matrix[i][edges[i][k][0]]=edges[i][k][1];
				 System.out.print("("+edges[i][k][0]+","+edges[i][k][1]+") ");
				 }
			 }
			 System.out.println();
		 }
		 int shortPaths[]=new int [matrix.length];
		 Arrays.fill(shortPaths,Integer.MAX_VALUE);
		 traverseMatrix(matrix);
		 traverseGraph( matrix,shortPaths,start,0,seen);
		 
		/* for(int i=0;i<shortPaths.length;i++)
		 {
			 if(shortPaths[i]==Integer.MAX_VALUE)
				 shortPaths[i]=-1;
		 }*/
		 shortPaths[start]=0;
		    return shortPaths;
		  }
	 
	 public static void traverseGraph(int [][]matrix,int paths[],int row,int sum,boolean[][]seen)
	 {
		
		 for(int j=0;j<matrix[row].length;j++)
		 {
			 if(matrix[row][j]>0 )
			 {
				 
				 sum+=matrix[row][j];
				 System.out.println("sum "+sum+" ( "+row+","+j+")");
				 //paths[j]=Math.min(paths[j],sum);

				 if(sum<paths[j])
				 {
					 System.out.println("less");
					 paths[j]=sum;
					 
					 System.out.println("------in----------");
					 traverseGraph(matrix, paths,j, sum,seen);
					 System.out.println("_____out_______");
				 }
				
				 
				 sum-=matrix[row][j];
				 System.out.println();
			 }
		 }
	 }

	 
	 public static void traverseMatrix(int [][]matrix)
	 {
		 for(int i=0;i<matrix.length;i++)
		 {
			 for(int k=0;k<matrix[i].length;k++)
			 {
				 System.out.print(matrix[i][k]+" ");
			 }
			 System.out.println();
			 
		 }
	 }
	 
	 

}
