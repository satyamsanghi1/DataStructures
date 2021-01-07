package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Trie
{
	Map<Character,Trie>node=new HashMap<>();
	boolean val;
	String value=null;
}
public class BoggleBoard {
	//my solution
	public static void main(String[] args) {

		String words[]= {"this","is","not","a","simple","boggle","board"};

	char [][]board=	 {
			    {'t', 'h', 'i', 's', 'i', 's', 'a'},
			    {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
			    {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
			    {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
			    {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
			    {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
			    {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			    {'N', 'O', 'T', 'R', 'E', '-', 'P'},
			    {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
			  };
	
			boggleBoard(board, words);
	}
	public static List<String> boggleBoard(char[][] board, String[] words) {

		Trie root=new Trie();
		 constructTrie(words, root);
		 traverseMap(root.node);
		 System.out.println(findWord(root,"is"));
		 
		 Set<String>set=new HashSet<>();
		List<String>list=new ArrayList<>();
		for(int i=0;i<board.length;i++)
		{
			for(int k=0;k<board[i].length;k++)
			{
				System.out.println("("+i+","+k+")");
					dfs(i,k,board,root,set);
			
			}
		}
		list.addAll(set);
	System.out.println("ans");
		System.out.println(list);
		
		return list;

	}
	public static void dfs(int i,int j,char[][] board,Trie root,Set<String>set)
	{

		if(i<0 || i>=board.length || j<0 || j>=board[i].length || !root.node.containsKey(board[i][j]) )
			return ;
		
		System.out.println("here " +board[i][j]);
		char temp=board[i][j];

		Trie next=root.node.get(temp);
		if(next.val)
		{
			System.out.println("word "+next.value +" at ("+i+","+j+")");
			set.add(next.value);
			
		}
		board[i][j]=' ';
		dfs(i-1,j,board,next,set) ;
		dfs(i+1,j,board,next,set) ;
		dfs(i,j-1,board,next,set) ;
		dfs(i,j+1,board,next,set);

		dfs(i-1,j-1,board,next,set) ;
		dfs(i+1,j+1,board,next,set);
		dfs(i-1,j+1,board,next,set) ;
		dfs(i+1,j-1,board,next,set);

		board[i][j]=temp;


	}
	public static void constructTrie(String [] words,Trie root)
	{
	
		for(String word:words)
		{
			Trie current=root;
			for(char c:word.toCharArray())
			{
				if(!current.node.containsKey(c))
				{
					current.node.put(c,new Trie());
				}
				current=current.node.get(c);
			}
			current.val=true;
			current.value=word;
		}
	
			System.out.println();
			
	}
	
	public static boolean findWord(Trie root,String word)
	{
		for(char c:word.toCharArray())
		{
			if(root.node.containsKey(c))
			{
				//System.out.println("contans");
				root=root.node.get(c);
			}
			else
				return false;
		}
		System.out.println("found "+root.value);
		return root.val;
	}
	public static void traverseMap(Map<Character,Trie>map)
	{
		map.forEach((k,v)->{
			System.out.println("key "+k);
		});
	}

}
