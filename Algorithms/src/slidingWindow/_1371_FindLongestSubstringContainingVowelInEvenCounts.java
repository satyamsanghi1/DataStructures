package slidingWindow;

import java.util.HashMap;

public class _1371_FindLongestSubstringContainingVowelInEvenCounts {
	// incomplete requires dynamic programming with bitmasking
	public static void main(String[] args) {
		
		String s="leetcodeisgreat";	
		
		findTheLongestSubstring(s);
		
	}
	 public static int findTheLongestSubstring(String s) {
	        
	        int bank[]=new int[26];
	        int evenCount=0;
	        int windowStart=0;
	        int windowEnd=0;
	        int longest=Integer.MIN_VALUE;
	        HashMap<Character,Integer>map=new HashMap<>();
	        
	        for(windowEnd=0;windowEnd<s.length();windowEnd++)
	        {
	            char c=s.charAt(windowEnd);
	            if(isVowel(c))
	            {
	               if(map.containsKey(c))
	               {
	            	   int value=map.get(c);
	            	   map.put(c, ++value);
	               }
	               else
	            	   map.put(c,1);
	            }
	            System.out.println(map.values());
	         /*   while(map.va)
	            {
	            longest=Math.max(longest,windowEnd-windowStart);
	            }*/
	        }
	        
	        return 0;
	    }
	    public static boolean isVowel(char c)
	    {
	        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
	            return true;
	        return false;
	    }

}
