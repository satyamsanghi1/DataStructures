package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1002_FindCommonCharacters {
	
	public static void main(String[] args) {
		
		System.out.println((char)97);
		
		String []s= {"cool","lock","cook"};
		commonChars(s);
	}
	public static List<String> commonChars(String[] A) {
        
	       int min_freq []=new int[26];
	        int current[]=new int[26];
	        
	        List<String>list=new ArrayList<String>();
	        
	        for(char c:A[0].toCharArray())
	        {
	            min_freq[c-97]++;
	        }
	        System.out.println();
	        traversechar(min_freq);
	        traverse(min_freq);
	        System.out.println();
	        System.out.println("_______________________");
	        for(int i=0;i<A.length;i++)
	        {
	            
	            for(char c:A[i].toCharArray())
	            {
	            current[c-97]++;
	            }
	            System.out.println("current");
	            traversechar(current);
		        traverse(current);
	              for(int c=0;c<26;c++)
	                {
	                if(min_freq[c]>current[c])	
	                {
	                	System.out.println("here");
	                    min_freq[c]=current[c];
	                }
	                }
	              System.out.println();
	              System.out.println("min");
	              traversechar(min_freq);
	  	        traverse(min_freq);
	             // or current=new int[26];
	  	        Arrays.fill(current,0);
	              System.out.println();
	              System.out.println();
	        }
	         for(int i=0;i<min_freq.length;i++)
	         {
	             if(min_freq[i]>0)
	             {
	                for(int k=0;k<min_freq[i];k++)
	                {
	                list.add((char)(i+97)+"");
	                }
	             }
	         }
	         System.out.println(list);
	        return list;
	        
	    }
	public static void traverse(int c[])
	{
		for(int i:c)
			System.out.print(i);
		
	}
	public static void traversechar(int c[])
	{
		
		for(int i=0;i<c.length;i++)
			System.out.print((char)(i+97));
		System.out.println();
	}

}
