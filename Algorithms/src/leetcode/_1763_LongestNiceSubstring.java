package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1763_LongestNiceSubstring {

	public static void main(String[] args) {
		//brute force
		
		String s="YazaAay";
		String ans=longestNiceSubstring(s);
		System.out.println("ans "+ans);
	}
	 public static String longestNiceSubstring(String s) {
	        
	        if(s.length()==0 || s.length()==1)
	            return "";
	       
	        char []c =s.toCharArray();
	        String longest="";
	        for(int i=0;i<c.length;i++)
	        {
	            for(int j=i;j<c.length;j++)
	            {
	                String sub=new String(c).substring(i,j+1);
	                System.out.println("sub "+sub);
	            String str=check(c,i,j);
	              
	                if(str.length()>0  && str.length()>longest.length())
	                {
	                    longest=str;
	                }
	                System.out.println("------------");
	            }
	        }
	        return longest;
	    }
	    
	    public static String check(char c[],int a,int b)
	    {
	        Set<Character>set=new HashSet<>();
	        Set<Character>setUpper=new HashSet<>();
	        
	        for(int i=a;i<=b;i++)
	        {
	            if(Character.isLowerCase(c[i]))
	                set.add(c[i]);
	        }
	        System.out.println("set "+set.toString());
	        int count=0;
	        for(int i=a;i<=b;i++)
	        {
	          if(Character.isUpperCase(c[i]))
	          {
	        	  setUpper.add(Character.toLowerCase(c[i]));
	          }
	        }
	        System.out.println("here");
	        
	     return  set.equals(setUpper)?new String(c).substring(a,b+1):"";
	    }
}
