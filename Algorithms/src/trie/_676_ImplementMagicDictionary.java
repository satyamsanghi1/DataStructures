package trie;

import java.util.Map;

public class _676_ImplementMagicDictionary {
	
	// 44 % Fast
	  static TrieNode root;
	   static int replace=0;
	
	public static void main(String[] args) {
		root=new TrieNode();
		buildDict(new String[] {"hello","leetcode"});
		
		boolean ans=search("heetcode");
		
		System.out.println("ans "+ans);
	}
	public static void buildDict(String[] dictionary) {

		for(String word:dictionary)
			addWord(word);

	}
	public static void addWord(String word) {
		TrieNode node=root;
		for(char c:word.toCharArray())
		{
			if(!node.map.containsKey(c))
			{
				TrieNode n=new TrieNode();
				node.map.put(c,n);
			}
			node=node.map.get(c);
		}
		node.endOfWord=true;
	}

	public static boolean search(String searchWord) {
		replace=0;
		TrieNode node=root;
		System.out.println(searchWord);
		boolean ans= helper(searchWord,0,node);

		return ans;
	}
	public static boolean helper(String s,int index,TrieNode node)
	{
		/* Backtracking + Trie 
		 * 
		 * each char of s we, iterate the children of node 
		 * if the current char is equal to one of the char in children 
		 * then we move forward
		 * otherwise ,
		 * 	increase the replace count by one 
		 */

		if(index>=s.length())
		{
			System.out.println("in "+index+" replace "+replace);
			if(node.endOfWord && replace==1)
				return true;
			else
				return false;
		}
		if(replace>1)
		{
			System.out.println("replace > "+replace);
			return false;
		}
		// for changing node to its original value after recursion
		TrieNode temp=node;
		traverse(node.map);
		//iterating every char in children of current node
		for(char x:node.map.keySet())
		{
			System.out.println("char "+x);
			if(x!=s.charAt(index))
			replace++;
			boolean val= helper(s,++index,node.map.get(x));
			if(val)
				return true;
			index--;
			node=temp;
			if(x!=s.charAt(index))
			replace--;
		}

		return false;
	}
	public static void traverse(Map<Character,TrieNode>map)
	{
		for(char c:map.keySet())
			System.out.print(c+" ");
		System.out.println();
	}

}
