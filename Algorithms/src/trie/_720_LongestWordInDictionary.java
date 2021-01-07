package trie;

import java.util.HashSet;
import java.util.Set;




public class _720_LongestWordInDictionary {
	 static String ans;
	    static TrieNode root;
	    
	public static void main(String[] args) {
		//30%Fast
		
		String words[]={"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
		
			longestWord(words);
	}
	 public static String longestWord(String[] words) {
	   	        
	        String ans="";
	       root=new TrieNode();
	        for(String s:words)
	        {
	             add(s,root);
	        }
	      
	        for(String s:words)
	        {
	            if(search(s,root))
	            {
	            	System.out.println("in "+s.compareTo(ans)+" s "+s);
	            
	            	if(s.length()>ans.length()){
	            		ans=s;
	            	}
	            	 else if(s.length()==ans.length() && s.compareTo(ans)<0)
	                    {
	                        ans=s;
	                    
	                    }
	            }
	        
	        }
	        System.out.println("ans "+ans);
		 
		 return "";
	    }
	 
	 public static boolean search(String s,TrieNode root)
	 {
		 for(char c:s.toCharArray())
		 {
			 TrieNode n=root.map.get(c);
			 if(n==null)
				 return false;
			 if(!n.endOfWord)
				 return false;

			 root=n;
		 }
		 
		 return true;


	 }
	 public static void add(String s,TrieNode r)
	    {
	        TrieNode root=r;
	           
	        for(char c:s.toCharArray())
	        {
	            TrieNode t=root.map.get(c);
	            
	            if(t==null)
	            {
	                t=new TrieNode();
	            }
	            root.map.put(c,t);
	            root=t;
	            
	        }
	        root.endOfWord=true;
	    }
	 
	 
	

}
