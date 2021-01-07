package trie;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;




public class _720_LongestWordInDictionary2 {
	 static String ans;
	    static TrieNode root;
	    
	public static void main(String[] args) {
		//30%Fast
		
		String words[]={"a", "banana", "app", "appl", "ap", "apply", "apple"};
		
			longestWord(words);
	}
	 public static String longestWord(String[] words) {
		 //73%Fast
	  /*ALGO
	   * 
	   * Time : (nlogn)sorting + n for traversing over words
	   * First we sort so that smallest string comes first 
	   * so that prefix of any string will come before it
	   * 
	   * we start iterating over array of words
	   * if length of string is 1: then it does not have prefix hence
	   * 							we add it into the set 
	   * 
	   * or,if one char less from end of current String is present in set:
	   *  	we add current string in the set
	   *  
	   *  finally we compare that we add the longest string than before
	   * 
	   */
	     Arrays.sort(words);
	     for(String s:words)
	    	 System.out.println(s);
	     String res="";
		 
	     Set<String>set=new HashSet<>();
	     for(String s:words)
	     {
	    	 if(s.length()==1 || set.contains(s.substring(0,s.length()-1)))
	    	 {
	    		 if(s.length()>res.length())
	    		 {
	    			 res=s;
	    			 set.add(s);
	    		 }
	    	 }
	     }
	     System.out.println("res "+res);
	     return res;
	    }
	 
	
}
