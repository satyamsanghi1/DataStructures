package slidingWindow;

import java.util.Arrays;
import java.util.HashSet;

public class _03_LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		
		String s="abcabcbb";
		
		//lengthOfLongestSubstring(s);
		alter(s);
	}
	
	public static int alter(String s)
	{
			int bank[]=new int[26];
			int max=Integer.MIN_VALUE;
			
			int count=0;
			int windowStart=0;
			for(int windowEnd=0;windowEnd<s.length();windowEnd++)
			{
				bank[s.charAt(windowEnd)-'a']++;
				if(bank[s.charAt(windowEnd)-'a']==0)
				{
				}
					
				else
				{
					//continue removing element from start till this freq of char becomes 1
					while(bank[s.charAt(windowEnd)-'a']>1)
					{
					traverseChar(bank);
					traverse(bank);
					System.out.println("windowEnd "+windowEnd);
					bank[s.charAt(windowStart)-'a']--;
					windowStart++;
					
					}
					traverseChar(bank);
					traverse(bank);
					//bank[s.charAt(windowEnd)-'a']++;
				}
				//calculating max end becasue of unique elements continue till last
				// that case will not end in else 
				max=Math.max(max,(windowEnd-windowStart)+1);
				System.out.println("max "+max);
				
				System.out.println("window Start "+windowStart);
				System.out.println();
				
			}
			System.out.println("max ans "+max);
			return max;
	}
	public static void traverse(int []bank)
	{
		for(int i:bank)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void traverseChar(int [] bank)
	{
		for(int i=0;i<bank.length;i++)
		{
			System.out.print((char)(i+'a')+" ");
		}
		System.out.println();
	}
	 public static int lengthOfLongestSubstring(String s) {
	        
		 HashSet<Character>set=new HashSet<Character>();
		 int max=Integer.MIN_VALUE;
		 int windowStart=0;
		 
		 for(int windowEnd=0;windowEnd<s.length();windowEnd++)
		 {
			
			 if(!set.contains(s.charAt(windowEnd)))
			 {
				 set.add(s.charAt(windowEnd));
			 }
			 else {
			 System.out.println("set "+set+" max "+max);
			 
			 while(set.contains(s.charAt(windowEnd)))
			 {
				
				 set.remove(s.charAt(windowStart));
				 windowStart++;
				 System.out.println("deleting "+set);
			 }
			 set.add(s.charAt(windowEnd));
				
			 System.out.println();
		 }
			 max=Math.max(((windowEnd-windowStart)+1),max);
			 System.out.println("s "+set);
		 }
		 System.out.println("max "+max);
		 return 0;
	    }
	 
	 

}
