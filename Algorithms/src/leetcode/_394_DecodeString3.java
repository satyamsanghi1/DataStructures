package leetcode;

import java.util.Stack;

public class _394_DecodeString3 {

	
	public static void main(String[] args) {
		//28%Fast
		
		String s="3[a2[c]]";
		decodeString(s);
		
	}
	   public static String decodeString(String s) {
		      
	        Stack<Integer>counts=new Stack<>();
	        Stack<String>results=new Stack<>();
	        String res="";
	        int i=0;
	        while(i<s.length())
	        {
	        	if(Character.isDigit(s.charAt(i)))
	        	{
	        		//find the full digit
	        		int val=0;
	        		while(Character.isDigit(s.charAt(i)))
	        		{
	        			val+=val*10+s.charAt(i)-'0';
	        			i++;
	        		}
	        		counts.push(val);
	        	}
	        	else if(s.charAt(i)=='[')
	        	{
	        		results.push(res);
	        		res="";
	        		i++;
	        	}
	        	else if(s.charAt(i)==']')
	        	{
	        		StringBuilder sb=new StringBuilder(results.pop());
	        		int count=counts.pop();
	        		for(int k=0;k<count;k++)
	        		{
	        			sb.append(res);
	        		}
	        		res=sb.toString();
	        		i++;
	        	}
	        	else
	        	{
	        		res+=s.charAt(i);
	        		i++;
	        	}
	        	System.out.println("res "+res);
	        }
	        
	        return res;
	        
	    }
	  
	
}
