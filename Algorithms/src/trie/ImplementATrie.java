package trie;

import java.util.HashMap;

class Triee
{
	/// LEETCODE 208
	
	public HashMap<Character,Triee>map=new HashMap<>();
	public boolean endOfWord=false;

	public void insert(String word) {

		Triee t=this;

		for(char c:word.toCharArray())
		{
			Triee t2=t.map.get(c);
			if(t2==null)
			{
				t2=new Triee();
				t.map.put(c,t2);

			}
			t=t2;

		}
		t.endOfWord=true;

	}

	public boolean search(String word) {

		Triee t=this;

		for(char c:word.toCharArray())
		{
		
			Triee t2=t.map.get(c);
			if(t2==null)
			{
				return false;

			}
			t=t2;

		}
		if(t.endOfWord==true)
			return true;
		
		else return false;
		
	}
	public boolean startsWith(String prefix) {

		Triee t=this;

		for(char c:prefix.toCharArray())
		{
			Triee t2=t.map.get(c);
			if(t2==null)
			{
			return false;
			}
			t=t2;

		}
		return true;

	}
}

public class ImplementATrie {

	public static void main(String[] args) {
			
			Triee t=new Triee();
			t.insert("a");
			t.insert("ab");
			t.insert("apple");
			System.out.println(t.search("ab"));
			
			System.out.println(t.startsWith("app"));
	}
}





































