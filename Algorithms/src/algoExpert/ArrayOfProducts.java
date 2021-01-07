package algoExpert;

public class ArrayOfProducts {

	//Leetcode 238
	public static void main(String[] args) {
		
		int nums[]= {1,2,3,4};
		productExceptSelf(nums);
	}
	
	 public  static int[] productExceptSelf(int[] nums) {
	        //100%Fast but using extra space
	        int sum=1;
			int ans[]=new int [nums.length];
	        int left[]=new int [nums.length];
		
	        int right[]=new int [nums.length];
		
		
	           for(int k=nums.length-1;k>=0;k--)
				{
	               sum*=nums[k];
				    right[k]=sum;
				}
	        sum=1;
	        for(int i=0;i<nums.length;i++)
			{
	             sum*=nums[i];
				    left[i]=sum;
	        }
	        
	        
			for(int i=0;i<nums.length;i++)
			{
	            int l=1,r=1;
	            if(i-1>=0)
	            l=left[i-1];
	            
	            if(i+1<nums.length)
	            r=right[i+1];
	            
	            ans[i]=l*r;
	            System.out.println("L "+l+" R "+r+" , "+ans[i]);
			}
		
	    return ans;
	    }
}
