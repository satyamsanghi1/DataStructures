package trie;

import java.util.HashMap;


public class _208_ImplementTree_prefix {
		//43%Fast
	 private TrieNode root;
	    
	    /** Initialize your data structure here. */
	    public _208_ImplementTree_prefix() {
	         root = new TrieNode();
	    }
	     
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        
	         TrieNode node = root;
	        
			for(char c:word.toCharArray())
			{
				TrieNode node2=node.map.get(c);
				if(node2==null)
				{
					node2=new TrieNode();
					node.map.put(c,node2);

				}
				node=node2;

			}
			node.endOfWord=true;

	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {

	         TrieNode node = root;

			for(char c:word.toCharArray())
			{
				TrieNode n=node.map.get(c);
				if(n==null)
				{
					return false;
				}
				node=n;

			}
			return node.endOfWord;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        	

		  TrieNode node = root;

			for(char c:prefix.toCharArray())
			{
				TrieNode n=node.map.get(c);
				if(n==null)
				{
					return false;
				}
				node=n;

			}
			return true;
	    }
}
