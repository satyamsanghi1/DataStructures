package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _290_WordPattern 
{
	public static void main(String[] args) {
		 
		String pattern="hut";
		
		String str="a abc abc a";
		
		wordPattern(pattern, str);
		
	}
	public static boolean wordPatternAlter(String pattern, String str)
	{
		String a[]=str.split(" ");
		
		HashMap<Character,String >map=new HashMap<>();
		
		HashSet<String>set=new HashSet<>();
		
		for(int i=0;i<a.length;i++)
		{
			if(!map.containsKey(pattern.charAt(i)))
			{
				if(!set.contains(a[i]))
				{
					map.put(pattern.charAt(i),a[i]);
					set.add(a[i]);
				}
			}
			else
			{
				if(map.get(pattern.charAt(i)).equals(a[i]))
						{
					
						}
			}
			
		}
		return false;
	}
	 public static boolean wordPattern(String pattern, String str)
	 {
	      
		int a[]=new int[26];
		
		String s[]=new String[26];
		
		String sp[]=str.split(" ");
	//	System.out.println('z'-97);
		
		String prevString="";
		String currentString="";
		String indexString="";
		
		for(int i=0;i<pattern.length();i++)
		{
			int index=pattern.charAt(i)-97;
			System.out.println(index);
			
			currentString=sp[i];
			if(a[index]==0) {
				
				System.out.println("inserting");
				a[index]=1;
				s[index]=sp[i];
				
				indexString=sp[i];
			}
			else 
			{
				indexString=s[index];
			
			}
			
			if(indexString.equals(currentString))
			{
				System.out.println("here");
				if(i!=0) {
				char prev=pattern.charAt(i-1);
				char current=pattern.charAt(i);
				
				System.out.println("prev "+prev);
				System.out.println("curr "+current);
				if(prev!=current && !sp[i].equals(s[i-1]))
				{
					System.out.println("true unequal");
				}
				else if(prev==current && sp[i].equals(sp[i-1]))
				{
					System.out.println("true equal");
				}
				else
				{
					System.out.println("condition false");
				}
				System.out.println("current String "+sp[i]);
				System.out.println("prev string "+s[index]);
				
				}
			}
			else
			{
				System.out.println("fiririri");
				//return false
			}

				System.out.println("index String "+indexString);
			
				System.out.println("here for "+pattern.charAt(i));
				
			
			
			System.out.println();
			System.out.println();
		}
		
		int i=pattern.charAt(pattern.length()-1)-97;
		System.out.println(pattern.charAt(pattern.length()-1)-97);
		System.out.println(s[2]);
		System.out.println(s[0]);
		System.out.println(s[i]);
		if(pattern.charAt(0)!=pattern.charAt(pattern.length()-1)  && s[pattern.charAt(0)-97].equals(s[i]))
		{
			System.out.println("final false");
		}
			
		
		System.out.println("traversing");
		for(int q:a)
			System.out.print(q+" ");
		System.out.println();
		for(String q:s)
			System.out.print(q+" ");
			 return false;
	       
		
	    }
	 
	 
}
