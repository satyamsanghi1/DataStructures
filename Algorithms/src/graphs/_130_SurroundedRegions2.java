package graphs;

import java.util.ArrayList;
import java.util.List;

public class _130_SurroundedRegions2 {
	
	/*100%
	 * 1) we iterate over boundaries and if there is any O at bounday 
	 * 		we apply dfs and turns that region with different char
	 * 
	 * 2) after that we are safe , remaining O elements can be easily converted into X
	
	 * 
	 *  
	 */
	public static void main(String[] args) {
	
		char [][] board=				
			{{'O','X','X','O','X'}
			,{'X','O','O','X','O'}
			,{'X','O','X','O','X'}
			,{'O','X','O','O','O'}
			,{'X','X','O','X','O'}};
		
		solve(board);
		System.out.println("answer");
		traverse(board);
		
	}
	 public static void solve(char[][] board) {
	        
	      
	       
	        //traversing first and last row 
		 for(int i=0;i<board[0].length;i++)
		 {
			 
			 if(board[0][i]=='O')
				 dfs(0,i,board);
			 
			 if(board[board.length-1][i]=='O')
				 dfs(board.length-1,i,board);

		 }
		 //traversing first and last column
		 for(int i=0;i<board.length;i++)
		 {
			 
			 if(board[i][0]=='O')
				 dfs(i,0,board);
			 
			 if(board[i][board[0].length-1]=='O')
				 dfs(i,board[0].length-1,board);

		 }
		 traverse(board);
		 System.out.println("--------------------");

		 for(int i=0;i<board.length;i++)
		 {
			 for(int k=0;k<board[i].length;k++)
			 {
				 if(board[i][k]=='O')
					 board[i][k]='X';
				 else if(board[i][k]=='*')
					 board[i][k]='O';
			 }

		 }
	        
	            
	    }
	 public static void dfs(int i,int j,char [][]board)
	    {
	      if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]=='X' || board[i][j]=='*')
	        return ;
	    
	       
	        
	       board[i][j]='*';
	        
	       dfs(i-1,j,board);
	       dfs(i+1,j,board);
	       	dfs(i,j-1,board);
	    	dfs(i,j+1,board);
	        
	    }
	   
	    public static void traverse(char [][]board)
	    {
	    	
	        for(int i=0;i<board.length;i++)
	        {
	        for(int k=0;k<board[i].length;k++)
	        {
	           System.out.print(board[i][k]+",");
	        }
	        System.out.println();
	        }
	    }

}
