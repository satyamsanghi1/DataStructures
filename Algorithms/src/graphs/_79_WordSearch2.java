package graphs;

import java.util.HashMap;

public class _79_WordSearch2 {
	
	public static void main(String[] args) {
		//not working
		String word="ABCD";// false because C is diagonally present
		
		char [][]board= {
				{'A','B'},
				{'C','D'},
				
				};
		
				boolean ans=exist(board, word);
		System.out.println("anns "+ans);
		}
      
	
	 public static boolean exist(char[][] board, String word) {
	        
	        
	       boolean [][]seen=new boolean[board.length][board[0].length];
	        
	        for(int i=0;i<board.length;i++)
	        {
	        for(int k=0;k<board[i].length;k++)
	        {
	        	 if(board[i][k]==word.charAt(0))
	             {
	                 //finding the word by using dfs
	                // removeFromMap(map,board[i][k]);
	                if( dfs(i,k,board,word,0))
	                    return true;
	                 
	             }
	          System.out.println("------------");
	             //map.put(board[i][k],map.getOrDefault(board[i][k], 0)+1);

	           
	            
	        }
	            
	        }
	        return false;
	    }
	
	 public  static boolean dfs(int i,int j,char[][]board,String word,int count)
	 {
		 	System.out.println("count "+count);
		 if(count==word.length())
			 return true;
		 if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count) )
			 return false ;

		 System.out.println("here " +board[i][j]+"at ("+i+","+j+")"+" count "+count);
		 
		 char temp=board[i][j];
		 board[i][j]=' ';
		 boolean val=    dfs(i-1,j,board,word,count+1) ||
				 dfs(i+1,j,board,word,count+1) ||
				 dfs(i,j-1,board,word,count+1) ||
				 dfs(i,j+1,board,word,count+1);
		 board[i][j]=temp;
		 
		 return val;
		 // map.put(board[i][j],map.getOrDefault(board[i][j], 0)+1);


	 }
	   
	   
}
