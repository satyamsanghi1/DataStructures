package graphs;

import java.util.ArrayList;
import java.util.List;

public class _130_SurroundedRegions {
	
	/*
	 * 16 %Fast
	 * when we reach one index before border and ther is O we have to return from there
	 * 
	 * when doing dfs , we turn flag=true when we find a O at boundary
	 * and convert elements into X also add elements into list and their original value
	 * 
	 * if dfs return is true ,then we have to revert ,convert these elements into Z
	 * so that we does not come again at these elements , functionality like seen 
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
	        
	        if(board.length==0)
	           return ;
	        List<Integer[]>list1=new ArrayList<>();
	          for(int i=1;i<board.length-1;i++)
	        {
	        for(int k=1;k<board[i].length-1;k++)
	        {
	            if(board[i][k]=='O')
	            {
	    	        List<Integer[]>list=new ArrayList<>();

	            	System.out.println("found at ("+i+","+k+")");
	               
	                
	                boolean z=dfs(i,k,board,list);
	                System.out.println("z "+z);
	                if(z)
	                {
	                	list1.addAll(list);
	                    revert(board,list);
	                }
	                traverse(board);
	                
		            System.out.println("__________");
		            	//break;
	            }
	            //break;
	        }
	        System.out.println("------------");
	        }
	         
	          
	          for(Integer[]a:list1)
	          {
	        	 int i=a[0];
	        	 int j=a[1];
	        	 if(board[i][j]=='Z')
	        	board[i][j]=(char)(int)a[2];
	        	
	          }
	        	  
	        
	            
	    }
	 public static boolean dfs(int i,int j,char [][]board,List<Integer[]>list)
	    {
	      if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]=='X' || board[i][j]=='Z')
	        return false;
	    
	    boolean flag=false;
	        if(i-1==0 && board[i-1][j]=='O')
	        	flag=true;
	        	
	        	if(i+1==board.length-1 && board[i+1][j]=='O')
	        		flag=true;

	        
	         if(j-1==0 && board[i][j-1]=='O')
	        	 flag=true;
	         if(j+1==board[i].length-1 && board[i][j+1]=='O')
	        	 flag=true;

	        
	        list.add(new Integer[]{i,j,(int)board[i][j]});
	       board[i][j]='X';
	        
	   boolean a=    dfs(i-1,j,board,list);
	   boolean b=   	dfs(i+1,j,board,list);
	   boolean c=   	dfs(i,j-1,board,list);
	   boolean d=   	dfs(i,j+1,board,list);
	        
	      
	        return flag|| a||b || c||d;
	    }
	    public static void revert(char [][]board,List<Integer[]>list)
	    {
	        for(Integer[]a:list)
	        {
	            int i=a[0];
	            int j=a[1];
	            board[i][j]='Z';
	        }
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
