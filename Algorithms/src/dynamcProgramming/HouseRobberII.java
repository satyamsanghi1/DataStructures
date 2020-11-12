package dynamcProgramming;

public class HouseRobberII {
	
	public static void main(String[] args) {
		
		int nums[]= {1,2};
		
		rob(nums);
	}
	 public static int rob(int[] nums) {
	        
	        if(nums.length==0)
	            return 0;
	        
	        int a=helper(nums,0,nums.length-1);
	        int b=helper(nums,1,nums.length);
	        	
	        System.out.println(Math.max(a, b));
	        return 0;
	    }
	 public static int helper(int []nums,int a,int b)
	 {
		  int first=0;
	        int second=0;
	        int current=0;
	        
	        for(int i=a;i<b;i++)
	        {
	            current=Math.max(first,second+nums[i]);
	            second=first;
	            first=current;
	            
	       
	        }
	        return current;
	 }
	 
	 

}
