package graphs;

public class _286_WallsAndGates {
	
	public static void main(String[] args) {
		
		//locked in leetcode access at lint code
		
	}
	public void wallsAndGates(int[][] rooms) {

		if(rooms.length==0)
			return ;
		boolean seen[][]=new boolean [rooms.length][rooms[0].length];


		for(int i=0;i<rooms.length;i++)
		{
			for(int j=0;j<rooms[i].length;j++)
			{

				if(rooms[i][j]==0)
				{
					//apply dfs

					dfs(i,j,rooms,0,seen);
				}
			}
		}
	}

	 public void dfs(int i,int j,int [][]rooms , int dist,boolean [][]seen)
	    {
	               // System.out.println("dfs called");

	        if(i<0 || i>=rooms.length || j<0 || j>=rooms[i].length || rooms [i][j]==-1  ||seen[i][j])
	        return ;
	        
	                     //   System.out.println("dfs called");

	        if(rooms[i][j]!=0)
	        rooms[i][j]=Math.min(rooms[i][j],dist+1);
	        seen[i][j]=true;
	        
	        if(i-1>=0 && rooms [i-1][j]!=0)
	         dfs(i-1,j,rooms,rooms[i][j],seen);
	         
	          if(i+1<rooms.length && rooms [i+1][j]!=0)
		       dfs(i+1,j,rooms,rooms[i][j],seen);
		       
		        if(j-1>=0 && rooms [i][j-1]!=0)
		       	dfs(i,j-1,rooms,rooms[i][j],seen);
		       	
		       	 if(j+1<rooms[i].length && rooms [i][j+1]!=0)
		    	dfs(i,j+1,rooms,rooms[i][j],seen);
		    	
		    	seen[i][j]=false;
	    }

}
