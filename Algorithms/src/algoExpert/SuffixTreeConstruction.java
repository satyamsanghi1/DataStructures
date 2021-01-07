package algoExpert;

import java.util.HashMap;
import java.util.Map;

public class SuffixTreeConstruction {

	public static void main(String[] args) {
		
		
		SuffixTreeConstruction.SuffixTrie t=new SuffixTreeConstruction.SuffixTrie("babc");
		t.traverse();
		boolean ans=t.contains("abc");
		System.out.println("ans "+ans);
	}
	 static class TrieNode {
		    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
				char endSymbol;
		  }

		  static class SuffixTrie {
		    TrieNode root = new TrieNode();
		    char endSymbol = '*';

		    public SuffixTrie(String str) {
		      populateSuffixTrieFrom(str);
		    }

		    public void populateSuffixTrieFrom(String str) {
		     
					TrieNode node=this.root;
					
					for(int i=0;i<str.length();i++)
					{
						//for every string i
						String s=str.substring(i,str.length());
						System.out.println("s "+s);
						node=this.root;
						for(char c:s.toCharArray())
						{
							if(!node.children.containsKey(c))
							{
								TrieNode r=new TrieNode();
								node.children.put(c,r);
							}
							node=node.children.get(c);
						}
						node.endSymbol=this.endSymbol;	
							//break;
						System.out.println("--------------");
					}
					
		    }

		    public boolean contains(String str) {
		     
					TrieNode node=this.root;
					for(char c:str.toCharArray())
					{
						TrieNode n=node.children.get(c);
						
						if(n==null)
							return false;
						node=n;
					}
					System.out.println("symbol "+node.endSymbol);
					if(node.endSymbol!='*')
						return false; 
					
		      return true;
		    }
		    
		    public void traverse()
		    {
		    	
		    	
		    	TrieNode node=this.root;
		    	String str="abc";
		    	for(char c:str.toCharArray())
				{
					TrieNode n=node.children.get(c);
					if(n==null)
						break;
					node.children.forEach((k,v)->{
			    		System.out.println(k);
			    		
			    	});
					System.out.println("____");
					node=n;
				}
		    }
		  }
}
