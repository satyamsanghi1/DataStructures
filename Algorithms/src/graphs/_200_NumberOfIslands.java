package graphs;

import java.util.ArrayList;
import java.util.List;

public class _200_NumberOfIslands {
	
	public static void main(String[] args) {
		
		/*when we visit any node we make it 0 so it can not be visted again
		 * as it is already visited
		 * 
		 * 
		 */
	}
	   public static int numIslands(char[][] grid) {
		   //99%Fast
		   int size=0;
			for(int i=0;i<grid.length;i++)
			{
			for(int j=0;j<grid[0].length;j++)
			{
	            
				if(grid[i][j]=='1')
	            {
	                size++;//we found a land
	                //applying dfs on this node
	                dfs(i,j,grid);
	                
	            }
			
			}
			}
	    return  size;
		   
	   }
	   public static void dfs(int i,int j,char [][]grid)
	    {
		   //if out of bounds then return 
	    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0')
	        return ;
	        
	    //making the node visited
	        grid[i][j]='0';
	        
	        // there can be atmost 4 neighbours hence applying dfs on 4 neighbours
	        dfs(i-1,j,grid);
	        dfs(i+1,j,grid);
	        dfs(i,j-1,grid);
	        dfs(i,j+1,grid);
	    }

}
