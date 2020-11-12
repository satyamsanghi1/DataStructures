import java.io.*;
		
public class PlacementPrograms {

	 public static boolean isPalindrome(int x) {
		 boolean flag=false;
	       int k=0,j;
	        while(x<0)
	        {
	        j=x%10;
	            k=k*10+j;
	            x=x/10;
	            
	        }
	        System.out.println(k);
	        if(k==x)
	           flag=true;
	        else if(k!=x)
	         flag=false;
	        else {}
	          
	        return flag;
	    }
	
	public static void main(String arg[])
	{
System.out.println(isPalindrome(-121));
		    }
}
	

