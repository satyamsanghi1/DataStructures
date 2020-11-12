package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _200_NumberOfIslandsII {
	
	public static void main(String[] args) {
		
		/*when we visit any node we make it 0 so it can not be visted again
		 * as it is already visited
		 * 
		 * 
		 */
	}
	
	   public int findNoOfIslands(int [][]grid,boolean [][]seen)
	    {
	       for(int i=0;i<grid.length;i++)
	       Arrays.fill(seen[i],false);
	       
	          int size=0;
				for(int i=0;i<grid.length;i++)
				{
				for(int j=0;j<grid[0].length;j++)
				{
		            
					if(grid[i][j]==1  && !seen[i][j])
		            {
		                size++;//we found a land
		                //applying dfs on this node
		                dfs(i,j,grid,seen);
		                
		            }
				
				}
				}
		    return  size;
	    }
	       public  void dfs(int i,int j,int [][]grid,boolean [][]seen)
		    {
			   //if out of bounds then retur
		    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || seen[i][j])
		        return ;
		        
		    //making the node visited
		       // grid[i][j]=0;
		        seen[i][j]=true;
		        // there can be atmost 4 neighbours hence applying dfs on 4 neighbours
		        dfs(i-1,j,grid,seen);
		        dfs(i+1,j,grid,seen);
		        dfs(i,j-1,grid,seen);
		        dfs(i,j+1,grid,seen);
		        
		    }
}
