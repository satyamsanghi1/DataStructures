package LeetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _438_FindAllAnagramsInString {
	
	public static void main(String[] args) {
		
		String s="abab";
		
		String p="ab";
		System.out.println(findAnagrams(s, p));
	}
	
	 public  static List<Integer> findAnagrams(String s, String p) {
	     //18%Fast	
		 
	        HashMap<Character,Integer>map=new HashMap<>();
	        HashMap<Character,Integer>map1=new HashMap<>();
	        int start=0;
	        List<Integer>indexes=new ArrayList<>();
	        
	        for(int i=0;i<p.length();i++)
	        {
	            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
	            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
	            
	        }
	        
	        traverse(map);
	        System.out.println("-----------------------");
	 
	        for(int i=p.length();i<s.length();i++)
	        {
	        	if(map.equals(map1))
	        	{
	        		System.out.println("addd");
	        		indexes.add(i-p.length());
	        	}
	        	
	        	System.out.println("current "+i+" , start "+start);
	        	map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
	        	
	        	traverse(map1);
	        	
	        	
	        	
	        		
	        		int x=map1.get(s.charAt(start));
	        		
	        		System.out.println("x "+x);
	        		if(x==1)
	        		{
	        			map1.remove(s.charAt(start));
	        		}
	        		else
	        		{
	        			x--;
	        			map1.put(s.charAt(start),x);
	        		}
	        		start++;
	        	
	        	System.out.println("_________");
	        	traverse(map1);
	        	
	        	
	        	
	        	System.out.println("--------------------------------------------");
	        }
	        if(map1.equals(map))
	        indexes.add(s.length()-p.length());
	        
	        System.out.println("ans "+indexes);
	 return null;
	 }
	 
	 public static void traverse(HashMap<Character,Integer>map) {
		 
		 for(Entry<Character,Integer>e:map.entrySet())
		 {
			 System.out.println(e.getKey()+" , "+e.getValue());
		 }
		 
	 }
}
