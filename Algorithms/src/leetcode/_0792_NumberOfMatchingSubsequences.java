package leetcode;

import java.util.HashMap;

public class _0792_NumberOfMatchingSubsequences {
	
	public static void main(String[] args) {
		
		String s="abcd";
		
		String a[]= {"a","a","e","e"};
		System.out.println(numMatchingSubseq(s,a));
	}
	 public static int numMatchingSubseq(String S, String[] words) {
	        
	        int count=0;
	       
	        HashMap<String,Integer>map=new HashMap<String,Integer>();
	        
	        for(String s:words)
	        {
	            if(map.containsKey(s))
	            {
	                int value=map.get(s);
	                map.put(s,++value);
	            }
	            else
	            {
	                map.put(s,1);
	            }
	        }
	             for(String s:map.keySet())
	             {
	        if(s.length()==0)
	           break;
	        if(s.equals(S))
	            count++;
	        
	        int s_pointer=0;
	        for(int i=0;i<S.length();i++)
	        {
	            if( s_pointer<s.length() && s.charAt(s_pointer)==S.charAt(i))
	            {
	                s_pointer++;
	            }
	            if(s_pointer==s.length())
	                break;
	        }
	        if(s_pointer==s.length())
	        {
	            count+=map.get(s);
	        }
	        
	       
	    }
	         return count;
	}

}
