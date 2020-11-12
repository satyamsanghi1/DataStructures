package graphs;

import java.util.HashSet;
import java.util.Set;

public class _694_NumberOfDistinctIslands {
	
	public static void main(String[] args) {
		//working
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
	        
		 Set<String>set=new HashSet<String>();
		 for(int i=0;i<grid.length;i++)
		 {
			 for(int k=0;k<grid[i].length;k++)
			 {
				 if(grid[i][k]==1)
				 {
				 StringBuilder sb=new StringBuilder();
				 sb.append("s ");
				 dfs(i,k,grid,sb,"x");
				 set.add(sb.toString());
				 }
			 }
		 }
		 set.forEach((s)->{
			 System.out.println(s);
		 });
		 return 0;
	    }
	 
	 public static void dfs(int i,int j,int [][]grid,StringBuilder s,String direction)
	 {
		 if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid [i][j]==0 )
		 {
			 s.append("o");
		       return ;
		 }
		
		 grid[i][j]=0;
		
			 s.append(direction);
		 dfs(i-1,j,grid,s,"u");
	        dfs(i+1,j,grid,s,"d");
	        dfs(i,j-1,grid,s,"l");
	        dfs(i,j+1,grid,s,"r");
	        
	 }
	 
	 

}
