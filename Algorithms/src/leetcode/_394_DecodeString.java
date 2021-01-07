package leetcode;

public class _394_DecodeString {

	
	public static void main(String[] args) {
		
		
		
	}
	  public String[] helper(String s,int start,int end)
	    {

	        StringBuilder sb=new StringBuilder();
	     
	      
	        int repeat=0;
	        String[] ret=null;
	        for(int i=start;i<end;)
	        {
	          
	             //System.out.println("i "+i);
	            if(Character.isAlphabetic(s.charAt(i)))
	            {
	                sb.append(s.charAt(i)+"");    
	            }
	            
	            if(Character.isDigit(s.charAt(i)))
	            {
	                //how long the number is 
	                int k=i;
	                while(Character.isDigit(s.charAt(k)))
	                {
	                    k++;
	                }
	                repeat=Integer.parseInt(s.substring(i,k));
	                i=k-1;

	                ret=helper(s,i+2,end);
	                
	             StringBuilder x=new StringBuilder();
	                 for(int j=0;j<repeat;j++)
	                {
	                x.append(ret[0]);
	                }
	      
	                 sb.append(x);
	                 i=Integer.parseInt(ret[1]);
	                continue;
	            }
	            else if(s.charAt(i)==']')
	            {
	                return new String []{sb.toString(),(i+1)+""};
	            }
	            i++;
	        }
	        
	       
	        
	   return new String []{sb.toString(),end+""};
	    }
}
