package slidingWindow;

import java.util.Arrays;

public class LongestSubstringWithAtleastkRepeatingCharacters {
	
	public static void main(String[] args) {
		
		String s="hadccccccddddcccccddddddccccccccdddddddeeffgglhkj" ;
		int k=7;
		 
		longestSubstring(s, k);
	}

	 public static int longestSubstring(String s, int k) {
	     
		 int windowEnd=0;
		 int windowStart=0;
		 
		 int bank[]=new int[27];
		 
		 int countOfChars=0;
		 int countOfCharswithMinK=0;
		 
		 int longest=0;
		
		 for(windowEnd=0;windowEnd<s.length();windowEnd++)
		 {
			 
			char currentChar=s.charAt(windowEnd);
			System.out.println("current "+currentChar);
			 bank[currentChar-'a']++;
			 
			 if(bank[currentChar-'a']==1)
				countOfChars++;
			 
			 if(bank[currentChar-'a']==k)
				 countOfCharswithMinK++;
			 
			 System.out.println("CharswithMinK "+countOfCharswithMinK);
			 
			 if(countOfCharswithMinK==countOfChars)
				 longest=Math.max(longest,windowEnd-windowStart+1);
			
			 System.out.println();
		 }
		 System.out.println("longest "+longest);
		 System.out.println("windowENd  "+windowEnd);
		
		 System.out.println("CharswithMinK "+countOfCharswithMinK);
		 //second pass
		 System.out.println();
		 System.out.println();
		 System.out.println("second pass");
		countOfCharswithMinK=0;
		int count=0;
		 for(int i=0;i<s.length()-1;i++)
		 {
			 count++;
			 if(s.charAt(i)!=s.charAt(i+1))
			 {
				 System.out.println("here "+s.charAt(i+1));
				 if(count>=k)
				 {
					 System.out.println("updating "+count+"at i "+i);
					 longest=Math.max(longest,count);
					 
				 }
				 count=0;
			 }
		 }
		
	
		 System.out.println("longest "+longest);
		 return 0;
	    }
}
