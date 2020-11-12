package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class _076_MinimumWindowSubstring {
	

	public static void main(String[] args) {
		
		String s="adobecodebanc";
		
		String t="abc";
		//String s="ABDADB";
		//String t="AA";
				
		
		//String ans=minWindowAlter(s, t);
		String ans=minWindow(s, t);
		System.out.println("ans "+ans);
		//System.out.println(Math.abs(Double.MAX_VALUE+1));
	}
	public static String minWindow(String s, String t) {
		
		// https://www.youtube.com/watch?v=9odu9ImG9oY
		
		// best fastest
		String ret="";
        
		int windowStart=0;
		int min=Integer.MAX_VALUE;
		int count=0; // to track  how many no of char in s are present in t
		int letterCount[]=new int[26];
		
		for(char c:t.toCharArray())
		{
			System.out.println("c "+c);
			++letterCount[c-'a'];
		}
		traverse(letterCount);
		
		for(int windowEnd=0;windowEnd<s.length();windowEnd++)
		{
			System.out.println("current "+s.charAt(windowEnd));
			//letterCount[s.charAt(windowEnd)]--;
			if(letterCount[s.charAt(windowEnd)-'a']>0)
			{
				System.out.println("here");
				count++;
			}
			letterCount[s.charAt(windowEnd)-'a']--;
			traverse(letterCount);
			traverseChar(letterCount);
			System.out.println("while loop start");
			while(count==t.length())
			{
				System.out.println("here "+count);
				traverse(letterCount);
				traverseChar(letterCount);
				if((windowEnd-windowStart+1)<min)
				{
					System.out.println("windowstart "+windowStart);
					ret=s.substring(windowStart,windowEnd+1);
					min=(windowEnd-windowStart+1);
					System.out.println("min "+ret);
				}
				letterCount[s.charAt(windowStart)-'a']++;
				if(letterCount[s.charAt(windowStart)-'a']>0)
				{
					count--;
					
					
				}
				windowStart++;
			}
			System.out.println("while loop end");
			System.out.println();
		}
		return ret;
    }
	public static void traverse(int a[])
	{
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void traverseChar(int a[])
	{
		for(int i=0;i<26;i++)
			System.out.print((char)(i+'a')+" ");
		System.out.println();
	}
	
	 public static String minWindowAlter(String s, String t) {
		 
		   int windowStart=0;
	        String min="";
	        int max=Integer.MAX_VALUE;
	        HashMap<Character,Integer>mapt=new HashMap<Character,Integer>();
	        //creating map for t
	        for(char c:t.toCharArray())
	        {
	        	if(mapt.containsKey(c))
	        	{
	        		int value=mapt.get(c);
	        		mapt.put(c, ++value);
	        	}
	        	else
	        	{
	        	mapt.put(c,1);
	        	}
	        }
	        System.out.println("t ");
	        traverse(mapt);
	        System.out.println();
	        HashMap<Character,Integer>maps=new HashMap<Character,Integer>();
	        
	        for(int windowEnd=0;windowEnd<s.length();windowEnd++)
	        {
	        	System.out.println("current "+s.charAt(windowEnd));
	        	if(mapt.containsKey(s.charAt(windowEnd)))
	        	{
	        		System.out.println("adding to maps "+s.charAt(windowEnd));
	        		// if yes than add it to map
	        	if(maps.containsKey(s.charAt(windowEnd)))
	        	{
	        		int value=maps.get(s.charAt(windowEnd));
	        		maps.put(s.charAt(windowEnd), ++value);
	        	}
	        	else
	        	{
	        	maps.put(s.charAt(windowEnd),1);
	        	}
	        	}
	        	traverse(maps);
	        	System.out.println("checking");
	        	//boolean x=check(maps, mapt);
	        	//System.out.println("x "+x);
	        	while(check(maps, mapt))
	        	{
	        		System.out.println("here ");
	        		traverse(maps);
	        		if((windowEnd-windowStart)<max)
        		 	{
        		 		// if max is smaller than update max and calculateing substring
        		 		max=(windowEnd-windowStart);
        		 		min=s.substring(windowStart,windowEnd+1);
        		 		System.out.println(min);
        		 	}
	        		System.out.println("here "+maps.size() +" i "+windowEnd+" max "+max);
	 	        	
	        		
	 	        	if(maps.containsKey(s.charAt(windowStart)))
	 	        	{
	 	        		System.out.println();
	 	        		int value=maps.get(s.charAt(windowStart));
	 	        		if(value>1)
	 	        			maps.put(s.charAt(windowStart), --value);
	 	        		else 
	 	        			maps.remove(s.charAt(windowStart)); 	        		
	 	        	}
	 	        	System.out.println("after removing ");
	 	        	traverse(maps);
	 	        	windowStart++;
        		 	
	        		//break;
	        	}
	        	System.out.println();
	        }
	        return min;
	 }
	 public static boolean check(HashMap<Character,Integer>maps,HashMap<Character,Integer>mapt)
	 {
		 if(maps.size()!=mapt.size())
			 return false;
		 for(Entry<Character,Integer>e:maps.entrySet())
		 {
			 System.out.println("key "+e.getKey()+" value "+e.getValue());
			 // when a char occur more than req in beteween
			 
			 // in case S= ADOBBECODEBANC
			 //T =ABC 
			 if(e.getValue()>=mapt.get(e.getKey())) {}
			 else
				 return false;
			
		 }
		 return true;
	 }
	 public static void traverse(HashMap<Character,Integer>map)
	 {
		 for(Entry<Character,Integer>e:map.entrySet())
		 {
			 System.out.println("key "+e.getKey()+" value "+e.getValue());
		 }
	 }
	 

}
