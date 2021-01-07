package trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;



public class _820_ShortEncodingOfWords {
	
    static TrieNode root=new TrieNode();
    
	public static void main(String[] args) {
		/*28%fast
		 * 
		 * by using suffix tree
		 * Sort array of words acc to length as eg me,time
		 * me will come first and will create problem 
		 * 
		 * iterating over words
		 *  if word found in trie , skip 
		 *  
		 *  else creates its suffix tree and add to StringBuilder
		 * 
		 * 
		 * 
		 */
		String [] words= {"time", "atime","btime"};
		
		int len=minimumLengthEncoding(words);
		System.out.println("len "+len);
	}
	 public static int minimumLengthEncoding(String[] words) {
	        
	        Arrays.sort(words,new Comparator<String>(){

				@Override
				public int compare(String o1, String o2) {
					
				if(o1.length()>o2.length())
					return -1;
				return 0;
				}
	        	
	        } 
			);
	        for(String s:words)
	        {
	        	System.out.println(s);
	        }
	        return createSuffixTree(words);
	    }
	    
	    public static int createSuffixTree(String []words)
	    {
	       StringBuilder sb=new StringBuilder();
	        boolean flag=true;
	        for(int k=0;k<words.length;k++)
	        {
	             TrieNode node=root;
	            String s=words[k];
	           
	            if(!contains(s))
	            {
	                add(s);
	                sb.append(s+"#");
	            }
	        }
	        
	        return sb.length();
	        
	    }
	    public static void add(String s)
	    {
	       
	         for(int i=0;i<s.length();i++) // creating suffixes of each string
	            {
	              TrieNode node=root;
	             String x=s.substring(i,s.length());
	         for(char c:x.toCharArray())
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
	    }
	    public static boolean contains(String x)
	    {
	        TrieNode node=root;
	        for(char c:x.toCharArray())
	            {
	                if(!node.map.containsKey(c))
	                {
	                return false;
	                }
	         
	                node=node.map.get(c);
	            }
	        if(!node.endOfWord)
	            return false;
	        return true;
	    }

}
