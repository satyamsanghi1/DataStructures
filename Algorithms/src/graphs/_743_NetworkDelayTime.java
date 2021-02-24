package graphs;

import java.util.Arrays;
import java.util.Map;

public class _743_NetworkDelayTime {
		//not working
	public static void main(String[] args) {
		
		
		int [][] times=new int[][] {{1,2,1}};
				
		  networkDelayTime(times,2,2);
	}
	 public static int networkDelayTime(int[][] times, int N, int K) {
	        
		 K--;
		 int matrix[][]=new int [N][N];
		 for(int i=0;i<times.length;i++)
		 {
			 int x=times[i][0];
             int y=times[i][1];
             int time=times[i][2];
             
             matrix[x-1][y-1]=time;
		 }
		 traverseMatrix(matrix);
		 int shortPaths[]=new int [N];
		 Arrays.fill(shortPaths,Integer.MAX_VALUE);
		 traverseGraph( matrix,shortPaths,K,0);
		 
        int max=0;
		 for(int i=0;i<shortPaths.length;i++)
		 {
			 System.out.print(" "+shortPaths[i]);
			 if(shortPaths[i]!=Integer.MAX_VALUE)
             {
                 
                 max=Math.max(shortPaths[i],max);
             }
		 }
		
        return max;
    }
    public static void traverseGraph(int [][]matrix,int paths[],int row,int sum)
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
					 
					 traverseGraph(matrix, paths,j, sum);
				 }
				
				 
				 sum-=matrix[row][j];
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
