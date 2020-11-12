package graphs;

import java.util.HashMap;

public class _79_WordSearch {
	
	public static void main(String[] args) {
		//not working
		String word="ABCB";
		
		char [][]board= {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
				boolean ans=exist(board, word);
		System.out.println("anns "+ans);
		}
      
	
	 public static boolean exist(char[][] board, String word) {
	        
	        
	        HashMap<Character,Integer>map=new HashMap<>();
	        
	       for(char c:word.toCharArray())
	        {
	            map.put(c,map.getOrDefault(c, 0)+1);
	 
	        }
	       boolean [][]seen=new boolean[board.length][board[0].length];
	      traverse(map);
	        
	        for(int i=0;i<board.length;i++)
	        {
	        for(int k=0;k<board[i].length;k++)
	        {
	            if(map.containsKey(board[i][k]))
	            {
	                //finding the word by using dfs
	            	System.out.println("found ");
	               // removeFromMap(map,board[i][k]);
	                
	                traverse(map);

	                dfs(i,k,board,map,seen);
	                traverse(map);
	                if(map.size()==0)
	                    return true;
	                
	               
	            }
	          
	             //map.put(board[i][k],map.getOrDefault(board[i][k], 0)+1);

	           
	            
	        }
	            
	        }
	        return false;
	    }
	
	 public static void dfs(int i,int j,char[][]board,HashMap<Character,Integer>map,boolean [][]seen)
	    {
		
	        if(i<0 || i>=board.length || j<0 || j>=board[i].length || map.size()==0 || seen[i][j] || !map.containsKey(board[i][j]))
	            return ;
	        
	        System.out.println("here " +board[i][j]);
	      //  System.out.println(board[i][j]);
	        removeFromMap(map,board[i][j]);
	        seen[i][j]=true;
	        
	        dfs(i-1,j,board,map,seen);
	        dfs(i+1,j,board,map,seen);
	        dfs(i,j-1,board,map,seen);
	        dfs(i,j+1,board,map,seen);
	        
	       // map.put(board[i][j],map.getOrDefault(board[i][j], 0)+1);

	        
	    }
	    public static void removeFromMap(HashMap<Character,Integer>map,char c)
	    {
	        int value=map.get(c);
	        
	        if(value==1)
	            map.remove(c);
	        else
	            map.put(c,--value);        
	    }
	    public static void traverse(HashMap<Character,Integer>map)
	    {
	    	System.out.println("-------");
	    	 map.forEach((k,v)->{
		    	   
		    	   System.out.println("k "+k+" v "+v);
		       });
	    }

}
