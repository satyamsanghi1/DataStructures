package algoExpert;

public class ArrayOfProducts2 {

	//Leetcode 238
	public static void main(String[] args) {
		
		int nums[]= {1,2,3,4};
		productExceptSelf(nums);
	}
	
	 public  static int[] productExceptSelf(int[] nums) {
	        //100%Fast but using extra space
	        int sum=1;
			int ans[]=new int [nums.length];
	      
		
	           for(int k=nums.length-1;k>=0;k--)
				{
	               sum*=nums[k];
				    ans[k]=sum;
				}
	        sum=1;
	    /*    for(int i=0;i<nums.length;i++)
			{
	             sum*=nums[i];
				    left[i]=sum;
	        }*/
	        
	        int l=1;
			for(int i=0;i<nums.length;i++)
			{
	            int r=1;

	            if(i+1<nums.length)
	            r=ans[i+1];
	            
	            ans[i]=l*r;
	            l*=nums[i];
	            System.out.println("L "+l+" R "+r+" , "+ans[i]);
			}
		
	    return ans;
	    }
}
