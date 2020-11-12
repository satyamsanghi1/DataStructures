package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	// other version is group shifted Strings
	public static void main(String[] args) {
String str[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		groupAnagrams(str);
	
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
}
