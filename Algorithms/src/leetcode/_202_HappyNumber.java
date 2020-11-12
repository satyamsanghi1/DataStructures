package leetcode;

public class _202_HappyNumber {
	
	public static void main(String[] args) {
		
		boolean x=isHappy(19);
		System.out.println("ANSWER "+x );
	}
	 public static boolean isHappy(int n) {
	        
		
	        int x=n;
	    
	        while(true)
	        {
			/*
			 * if(count==20) { break; }
			 */
	        	int sum=0;
	        while(x>0)
	        {
	            int y=x%10;
	            x=x/10;
	            sum+=y*y;
	           
	        }
	      
	        if(sum==1) {
           
	        	return true;
	        	
	        }
	        // if 100 will not come 20 will come as sum
	        else if(sum==4)
	        	break;
	      
	        x=sum;
	     
	        }
	        return false;
	        
	    }

}
