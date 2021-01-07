package trie;

import java.util.Map;
import java.util.Map.Entry;

public class InsertionInTrie {
	

	
	public static void main(String[] args) {
		
		
		
		String a="airk";
		Trie root=new Trie();
		insert(root, a,0);
		//iterInsert(root, a);
		//iterInsert(root,"airk");
		insert(root,"aiop",0);
		insert(root,"ai",0);
		//insert(root,"ai",0);
		
		System.out.println("deleting ");
		boolean b=delete(root,"airk",0);
		System.out.println("deleted "+b);
		System.out.println();
		System.out.println("Searching");
		
			boolean x=recursiveSearch(root,"aio",0);
			
			System.out.println("ans "+x);
	
		//System.out.println(node);
		
		//search(root,"ai",0);
		
		//delete(root,"airko",0);
		System.out.println();
	
		//search(root,"airk",0);
		
		
	}
	public static void iterInsert(Trie node,String a)
	{
		for(int i=0;i<a.length();i++)
		{
			char ch=a.charAt(i);
			
			if(node.map.containsKey(ch))
			{
				System.out.println("already here");
				Trie next=node.map.get(ch);
				node=next;
			}
			else
			{
				Trie r=new Trie();
				node.map.put(ch,r);
				node=r;
			}
		
		}
		node.endOfWord=true;
	}
	public static void insert(Trie node,String a,int i)
	{
		//System.out.println("current node "+node);
		System.out.println("i "+i);
		
		if(i==a.length())
		{			
			node.endOfWord=true;		
			return ;
		}
		
		char ch=a.charAt(i);
		Trie n=node.map.get(ch);
		
		if(n==null)
		{
			n=new Trie();
			node.map.put(ch,n);
		}
		insert(n,a,++i);
	

	}
	
	public static boolean delete(Trie node,String s,int i)
	{
		if(i==s.length())
		{
			// equal to length because checking the last node of string which is extra
			System.out.println("here "+i);
			
			traverseMap(node.map);
			if(node.endOfWord==true)
			{
				node.endOfWord=false;
				
				if(node.map.size()==0)
				{

					return true;
				}
				else{
					System.out.println("size >0");
					return false;
				}
					
			}
			else
			{
				// the word does not exist so we dont delete anything
				System.out.println("not found");
				return false;
			}
		}
		
		char c=s.charAt(i);
		System.out.println("c "+c);
		
		Trie n=node.map.get(c);
		
		if(n==null)
		{
			
			 System.out.println("not found at "+c);
			return false;
		}
		boolean shouldDeleteCurrentNode=delete(n,s,++i);
		
		if(shouldDeleteCurrentNode )
		{
			System.out.println("char  "+c);
			node.map.remove(c);
			
			return node.map.size()==0 && node.endOfWord==false;
		}
		
		
		return false;
	}
	
	public static boolean iterSearch(Trie node,String s)
	{
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			System.out.println("c "+c);
			
			Trie n=node.map.get(c);
			
			if(n==null)
			{
				
				 System.out.println("not found at "+c);
				return false;
			}
			
			node=n;
		}
		if(node.endOfWord==true)
		{
			System.out.println("found");
			return true;
		}
		else
		{
			System.out.println("not found");
			return false;
		}
	
	}
	public static boolean recursiveSearch(Trie node,String s,int i)
	{
		if(i==s.length())
		{
			// equal to length because checking the last node of string which is extra
			System.out.println("here "+i);
			
			traverseMap(node.map);
			if(node.endOfWord==true)
			{
				System.out.println("found");
				return true;
			}
			else
			{
				System.out.println("not found");
				return false;
			}
		}
		
		char c=s.charAt(i);
		System.out.println("c "+c);
		
		Trie n=node.map.get(c);
		
		if(n==null)
		{
			
			 System.out.println("not found at "+c);
			return false;
		}
		return recursiveSearch(n,s,++i);
		
	}

	
	public static void traverseMap(Map<Character,Trie>map)
	{
		System.out.println("traversing map");
		System.out.println();
		for(Entry<Character,Trie>e:map.entrySet())
		{
			System.out.println("key "+e.getKey()+" , value "+e.getValue());
		
		}
	}

	

}
