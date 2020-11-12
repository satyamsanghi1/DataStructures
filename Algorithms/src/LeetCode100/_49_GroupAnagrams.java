package LeetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _49_GroupAnagrams {
	// other version group shifted Strings in leetcode package
	public static void main(String[] args) {
		
		
		String str[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		groupAnagrams(str);
	}
	public static List<List<String>> groupAnagrams2(String[] strs) {
		/*
		 * 42%
		 * creating a string of counts of char in each word
		 * and checking that String of count is in hashmap or not
		 */
		
		 if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;

	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	}
	 public static List<List<String>> groupAnagrams(String[] strs) {
		 //97%
		int i=0;
		 HashMap<String,List<String>>map=new HashMap<>();
		 /*
		  * sorting each word in list and checking if it is in map or not
		  * if present we get the list and add the word at index from input array
		  * 
		  * 
		  * if sorted the char of word we can easily check for duplicate words for same anagramms	
		  */
		 for(String s:strs)
		 {
			 char c[]=s.toCharArray();
			 Arrays.sort(c);
			 String x=new String(c);
			 if(map.containsKey(x))
			 {
				 List<String>l=map.get(x);
				 l.add(strs[i]);
				 map.put(x,l); 
			 }
			 else
			 {
				 List<String>l=new ArrayList<>();
				 l.add(strs[i]);
				 map.put(x,l);
			 }
			 i++;
		 }
		
		 return new ArrayList<>(map.values());
	 }
	 public static List<List<String>> groupAnagramsAlter(String[] strs) {
	        
		 //very slow 5 %
		 List<List<String>>ans=new ArrayList<>();
		 
		 HashMap<HashMap<Character,Integer>,ArrayList<String>>maps=new HashMap<>();
		 
		 
		 for(String s:strs)
		 {
			 HashMap<Character,Integer>m=new HashMap<>();
			 for(char c:s.toCharArray())
			 {
				 m.put(c,m.getOrDefault(c,0)+1);
			 }
			System.out.println("current map "+m);
			 System.out.println("maps "+maps.values());
			
			 if(maps.containsKey(m))
			 {
				 System.out.println("yes "+s);
				 ArrayList<String>value=maps.get(m);
				 value.add(s);
				 maps.put(m,value);
			 }
			 else
			 {
				 System.out.println("not present "+s);
				 ArrayList<String>newList=new ArrayList<>();
				 newList.add(s);
				 maps.put(m,newList); 
			 }
			 System.out.println();
			 
			 
			 
			 //break;
			 System.out.println("iterating");
		 }
		 for(Entry<HashMap<Character,Integer>,ArrayList<String>>e:maps.entrySet())
		 {
			 System.out.println(e.getValue());
			 ans.add(e.getValue());

		 }
		 
		 System.out.println("final ans "+ans);
		 //System.out.println(maps);
		 
		 
		 
		 
		 return null;
	    }
	 public static void traverse(HashMap<Character,Integer>map)
	 {
		 for(Entry<Character,Integer>e:map.entrySet())
		 {
			 System.out.println(e.getKey()+" , "+e.getValue());
		 }
	 }

}
