package leetcode;

import java.util.HashSet;
import java.util.Set;


public class _1763_LongestNiceSubstring2 {

	public static void main(String[] args) {
	
		
		System.out.println('a'-'a');
		String s="YazaAay";

		String ans=longestNiceSubstring(s);
		System.out.println("ans "+ans);
	}
	 public static String longestNiceSubstring(String s) {
	        
		 System.out.println("s "+s);
		 if (s.length() < 2) return "";
	        char[] arr = s.toCharArray();
	        Set<Character> set = new HashSet<>();
	        for (char c: arr) set.add(c);
	        for (int i = 0; i < arr.length; i++) {
	            char c = arr[i];
	            System.out.println("c "+c);
	            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
	            System.out.println("--------1------");
	            String sub1 = longestNiceSubstring(s.substring(0, i));
	            System.out.println("-------2-------");
	            String sub2 = longestNiceSubstring(s.substring(i+1));
	            return sub1.length() >= sub2.length() ? sub1 : sub2;
	            
	        }
	        return s; 
	    }
	    
	 
}
