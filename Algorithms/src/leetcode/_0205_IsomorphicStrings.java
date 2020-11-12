package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _0205_IsomorphicStrings {
	
	public static void main(String[] args) {
		
		String s="egg"; //ab
		
		String t= "add"; // ca
		
		//System.out.println(isIsomorphic(s, t));
		
		System.out.println(alter(s,t));
	}
	
	public static boolean alter(String s,String t)
	{
		int []a=new int[256];
		
		int b[]=new int[256];
		
		 for(int i=0;i<s.length();i++)
	        {
			 char j=s.charAt(i);
			 char k=t.charAt(i);
			 
			 System.out.println("current "+j);
			 if(a[j]!=0)
			 {
				 System.out.println("here");
				 if((char)a[j]!=k)
					 return false;
			 }
			 else
			 {
				 System.out.println("else");
				if(b[k]==0) {
				a[j]=(int)(k);
				b[k]++;
				}
				else
					return false;
				
			 }
			 
			 
			System.out.println();
			 
	        }
		return true;
		
		
		
		
		
		
		
		
	}
	
	
	
	public static boolean isIsomorphic(String s, String t) {

			 HashMap<Character,Character>map=new HashMap<Character,Character>();
		        
			 HashSet<Character>mapped=new HashSet<Character>();
			 
			
			 
		        for(int i=0;i<s.length();i++)
		        {
		        	System.out.println("current s "+s.charAt(i));
		            if(map.containsKey(s.charAt(i)))
		            {
		              char value=map.get(s.charAt(i));
		              if(value!=t.charAt(i))
		            	  return false;
		                
		            }
		            else
		            {
		            	System.out.println("here ");
		            	//if(!(mapped.contains(t.charAt(i)))){
		            		if(!map.containsValue(t.charAt(i))) {
		            		System.out.println("In");
		            	map.put(s.charAt(i),t.charAt(i));
		            	//mapped.add(t.charAt(i));
		            	
		            	}
		            	else
		            		return false;
	            	
	            
	            }
	        }
	        
	        return true;
	}


}
