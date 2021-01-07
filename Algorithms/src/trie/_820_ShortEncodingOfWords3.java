package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class TrieNode1{
	
	 HashMap<Character, TrieNode1> map = new HashMap<>();
	    int depth;
}

public class _820_ShortEncodingOfWords3 {
	
    
	public static void main(String[] args) {
	
		String [] words= {"me","time","bell"};
		
		int len=minimumLengthEncoding(words);
		System.out.println("len "+len);
	}
	public static int minimumLengthEncoding(String[] words) {
		/*
		 * 40%Fast Time : (∑w[i])
		 * when we add a word  in the trie , 
		 * the last map is empty  , and also we store the length of word +1(#)
		 * 
		 * we add the last map of every word in the list
		 * if the words map is empty  , then we add the depth into ans
		 * 
		 * 
		 * 
		 */
		 List<TrieNode1> leaves = new  ArrayList<TrieNode1>();
		TrieNode1 root=new TrieNode1();
		for(String s:new HashSet<>(Arrays.asList(words)))
		{
			TrieNode1 cur=root;
			for(int i=s.length()-1;i>=0;i--)
			{
				char c=s.charAt(i);
				
				 if (!cur.map.containsKey(c)) cur.map.put(c, new TrieNode1());
	                cur = cur.map.get(c);
				
			}
			 cur.depth = s.length() + 1;
	            leaves.add(cur);
		}
		int res = 0;
        for (TrieNode1 leaf : leaves) if (leaf.map.isEmpty()) res += leaf.depth;
        return res;
	}

}
