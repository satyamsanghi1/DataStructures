package leetcode;

public class _541_ReverseStringII {
	
	public static void main(String[] args) {
		
		String s="hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl"; 
			
		
		reverseStr(s,39);
		
	}
	 public static String reverseStr(String s, int k) {
	        
	        char arr[]=s.toCharArray();
	        int n=s.length();
	        int i=0;
	        System.out.println("n "+n);
	        while(i<s.length())
	        {
	        	System.out.println("i "+i);
	            if((n-i)>=2*k)
	            {
	                System.out.println("here");
	                reverse(arr,i,i+k-1);
	            }
	            else if((n-i)>=k && (n-i)<(2*k))
	            {
	                System.out.println("out");
	                reverse(arr,i,i+k-1);
	            }
	            else if((n-k)<k)
	            {
	                 System.out.println("in");
	                reverse(arr,i,n-1);
	            }
	            i+=(2*k);
	        }
	        String val=new String(arr);
	        return val;
	    }
	 
	public static void reverse(char []arr,int left,int right)
    {
        if(left>right)
            return ;
        
       
        char c=arr[left];
        arr[left]=arr[right];
        arr[right]=c;
        
      left++;
      right--;
      reverse(arr, left, right);
    }

}
