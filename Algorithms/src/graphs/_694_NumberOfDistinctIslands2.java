package graphs;

import java.util.HashSet;
import java.util.Set;

public class _694_NumberOfDistinctIslands2 {
	
	public static void main(String[] args) {
		//working 93%Fast
		
		//	https://www.youtube.com/watch?v=c1ZxUOHlulo
		int [][]grid =
			{
				    {1,1,0,0,0},
				    {1,1,0,0,0},
				    {0,0,0,1,1},
				    {0,0,0,1,1}
				 };
		numberofDistinctIslands(grid);
		
		
	}
	 public static int numberofDistinctIslands(int[][] grid) {
	        
	
		 // write your code here
	        if(grid.length==0)
	        return 0;
	         Set<String>set=new HashSet<String>();
			 for(int i=0;i<grid.length;i++)
			 {
				 for(int k=0;k<grid[i].length;k++)
				 {
					 //avoid string builder here
					 if(grid[i][k]==1)
					 {
					 StringBuilder sb=new StringBuilder();
					 sb.append("S");
					String x= dfs(i,k,grid,sb,"X");
					 set.add(x);
					 System.out.println(x);
					 return 0;
					 }
				 }
			 }
			 
			 
			 return set.size();
	    }
	 
	  public static String dfs(int i,int j,int [][]grid,StringBuilder s,String direction)
		 {
			 if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid [i][j]==0 )
			       return "O";
			 
			
			 grid[i][j]=0;
			 
		String a=	 dfs(i-1,j,grid,s,"U");
		   String b=     dfs(i+1,j,grid,s,"D");
		   String c=     dfs(i,j-1,grid,s,"L");
		   String d=     dfs(i,j+1,grid,s,"R");
		        
		        return direction+a+b+c+d;
		 }
	}
	 
	 


