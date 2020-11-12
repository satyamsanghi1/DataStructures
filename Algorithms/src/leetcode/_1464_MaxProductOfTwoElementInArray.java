package leetcode;

import java.util.Arrays;

public class _1464_MaxProductOfTwoElementInArray {
	
	public static void main(String[] args) {
		
		int a[]= {1,5,4,5};
		
		maxProduct(a);
	}
	public static int maxProduct(int[] nums) {
        
		// instead of sorting , we have to just find first and second max integer in array
		
		
        if(nums.length==0)
            return 0;
       
        int max1=0;
        int max2=0;
        
        for(int i:nums)	
        {
        	if(i>max1)
        	{
        		max2=max1;
        		max1=i;
        		
        	}
        	else if(i>max2)
        		max2=i;
        	
        }
        System.out.println("max1 "+max1+" max2 "+max2);
        int n=nums.length-1;
        int product=(nums[n-1]-1)*(nums[n]-1);
        return product;
        
    }


}
