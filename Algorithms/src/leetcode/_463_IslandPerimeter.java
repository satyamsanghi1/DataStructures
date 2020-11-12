package leetcode;

public class _463_IslandPerimeter {
	
	public static void main(String[] args) {
		
		int grid[][]= {	{0,1,0,0},
						{1,1,1,0},
						{0,1,0,0},
						{1,1,0,0}};
		
		islandPerimeter(grid);
		
	}
	 public  static int islandPerimeter(int[][] grid) {
	        
		 int perimeter=0;
		 
		 for(int i=0;i<grid.length;i++)
		 {
			
			 for(int k=0;k<grid[i].length;k++)
			 {
				 int current =4;
				 if(grid[i][k]==1)
				 {
					 
					 if( (k-1)>=0 && grid[i][k-1]==1)
					 {
						 current--;
					 }
					 if((k+1)<grid[i].length && grid[i][k+1]==1)
					 {
						 current--;
					 }
					 if((i-1)>=0 && grid[i-1][k]==1)
					 {
						 current--;
					 }
					 if((i+1)<grid.length && grid[i+1][k]==1)
					 {
						 current--;
					 }
					 perimeter+=current;
				 }
			 }
			 
			 //break;
		 }
		 System.out.println("perimeter "+perimeter);
		 
		 return perimeter;
	    }

}
