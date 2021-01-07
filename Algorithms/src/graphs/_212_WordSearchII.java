package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212_WordSearchII {
	//100%
	public static void main(String[] args) {
		
		
        Set<String>set=new HashSet<>();
        set.forEach((s)->{
        	
        });
	}
	 public List<String> findWords(char[][] board, String[] words) {
	        
	        Set<String>set=new HashSet<>();
	        
	        for(String word:words)
	            set.add(word);
	        
	        
	        List<String>list=new ArrayList<>();
	        
	        //for(int j=0;j<words.length;j++)//for each word
	        //{
	          set.forEach((s)->{
	           boolean flag=false;

	       
	        for(int i=0;i<board.length;i++)
	        {
	        for(int k=0;k<board[i].length;k++)
	        {
	        
	            if(board[i][k]==s.charAt(0))
	            {
	                if(dfs(i,k,board,s,0))
	                {
	                    list.add(s);
	                    flag=true;
	                    break;
	                }
	            }
	        }
	            if(flag)
	                break;
	        }
	               });
	        //}
	            return list;
	            
	    }      
    public boolean dfs(int i,int j,char[][] board,String word,int count)
    {
        
     if(count==word.length())
         return true;
            if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count) )
                return false ;

            //System.out.println("here " +board[i][j]);
        	 char temp=board[i][j];
	 board[i][j]=' ';
	 boolean val=    dfs(i-1,j,board,word,count+1) ||
			 dfs(i+1,j,board,word,count+1) ||
			 dfs(i,j-1,board,word,count+1) ||
			 dfs(i,j+1,board,word,count+1);
	 board[i][j]=temp;
	 
	 return val;
    }

}
