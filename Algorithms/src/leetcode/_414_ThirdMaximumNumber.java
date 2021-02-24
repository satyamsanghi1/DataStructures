package leetcode;

public class _414_ThirdMaximumNumber {
		//97%Fast

	public static void main(String[] args) {

		
		String s="0100";
		System.out.println(minOperations(s));

	}
	 public static int minOperations(String s) {
	     
	       
	       
	        int a=0;
	        int b=0;
	      
	        	System.out.println("0 at start");
	           a=helper(s.toCharArray(),'0','1');
	            
	       
	        	System.out.println("1 at start");
	            b=helper(s.toCharArray(),'1','0');
	           
	            System.out.println("a "+a + " b "+b);

	            return 0;
	            
	   
	    }
	    public static int helper(char c[],char atEven,char atOdd)
	    {
	        int i=0;
	        int count=0;
	        while(i<c.length)
	        {
	           if(i%2==0)
	           {
	              if(c[i]==atOdd){
	                  c[i]=atEven;
	               count++;
	              }
	           
	           }
	            else
	            {
	                //odd
	                if(c[i]==atEven)
	                {
	                    c[i]=atOdd;
	                count++;     
	                }
	               
	            }
	           i++;
	        }
	        return count;
	    }
}
