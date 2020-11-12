package leetcode;

import java.util.HashMap;

public class _299_BullsAndCows {
	
	public static void main(String[] args) {
		
		
		String secret="1122";
		String guess="1222";
				
		String ans=getHint(secret, guess);
		System.out.println("answer "+ans);
	}
	 public static String getHintAlter(String secret, String guess) {
		 
		 String ans="";
		 
		 return ans;
	 }
	 public static String getHint(String secret, String guess) {
	     // very slow , 10 % fast    
		 
	        HashMap<Character,Integer>map=new HashMap<Character,Integer>();
	        
	        char []a=secret.toCharArray(); // secret
	        char b[]=guess.toCharArray(); // guess
	        for(char c:a)
	        {
	        	map.put(c,map.getOrDefault(c,0)+1);
	        }
	        
	        int bulls =0;
	        int cows=0;
	        
	       for(int i=0;i<guess.length();i++)
	       {
	    	   System.out.println("current "+b[i]);
	    	   if(map.containsKey(b[i]))
	    	   { 
	    		   if(a[i]==b[i])
	    		   {
	    				   
	    			   bulls++;
	    			
	    			   int count=map.get(b[i]);
		    		   System.out.println("count for "+b[i]+" , : "+count);
		    		  
	    			   if(count==1)
	    				   map.remove(b[i]);
	    			   else
	    				   map.put(b[i],--count);
	    		   }
	    		 
	    	   }
	    	   System.out.println("bulls "+bulls + "cows "+cows);
	    	   System.out.println("______________________");
	       }
	       System.out.println("for cows");
	       for(int i=0;i<guess.length();i++)
	       {
	    	   System.out.println("current "+b[i]);
	    	   if(map.containsKey(b[i]))
	    	   {
	    		   	if(a[i]!=b[i])
	    		   	{
	    			cows++;   
	    			
	    			   int count=map.get(b[i]);
		    		   System.out.println("count for "+b[i]+" , : "+count);
		    		  
	    			   if(count==1)
	    				   map.remove(b[i]);
	    			   else
	    				   map.put(b[i],--count);
	    		   
	    		   	} 
	    		 
	    	   } System.out.println("bulls "+bulls + "cows "+cows);
	    	   System.out.println("______________________");
	       }
	        String ans=bulls+"A"+cows+"B";
	        return ans;
	    }
	 public static void traverseMap(HashMap<Character,Integer>map)
	 {
		 
	 }

}
