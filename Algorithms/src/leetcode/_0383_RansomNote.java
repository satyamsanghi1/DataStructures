package leetcode;

import java.util.HashMap;

public class _0383_RansomNote {
	
	public static void main(String[] args) {
		
		
		 
		 String ransome="c";
		 String magazine="aab";
		 boolean ans=canConstruct(ransome, magazine);
		 
		 System.out.println("answer "+ans);
		 
	}
	 public static boolean canConstruct(String ransomNote, String magazine) {
	     
		
		System.out.println('z'-'a');
		
		char ch[]=new char[26];

		for(char c:magazine.toCharArray())
		{
			ch[c-97]++;
		}
		
		for(int c:ch)
			System.out.print(c+" ");
		
		System.out.println();
		 for(char c:ransomNote.toCharArray()) {
			 
			 if(ch[c-97]<1)
				 return false;
			 
			 else
				 ch[c-97]--;
			 
			 
		 }
	
	
		 return true;
		 
	    }

}
