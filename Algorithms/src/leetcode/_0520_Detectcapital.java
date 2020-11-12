package leetcode;

public class _0520_Detectcapital {
	
	public static void main(String[] args) {
		
		System.out.println(detectCapitalUse("leetcode"));
	}
	 public static boolean detectCapitalUse(String word) {
	        
	        char a[]=word.toCharArray();
	        boolean flag1=false;
	        boolean flag2=false;
	        
	        
	        
	        for(int i=0;i<a.length;i++)
	        {
	           if(Character.isUpperCase(a[i]))
	           {
	        	   if(i==0)
	        		   continue;
	        	   flag1=true;
	           }
	           else if(Character.isLowerCase(a[i]))
	           {
	        	  
	        	   flag2=true;
	           }
	           
	           if(flag1==true && flag2==true)
	        	   return false;
	          
	        }
	        
	        return true;
	    }

}
