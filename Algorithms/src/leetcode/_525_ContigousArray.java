package leetcode;

public class _525_ContigousArray {
	
	public static void main(String[] args) {
		
			int nums[]= {0,1,0,1,0,0,0,1,1,1};
			findMaxLength(nums);
		
	}
	
	 public static int findMaxLength(int[] nums)
	 	{
		 int i=0;
		 int j=0;
		 int count_0=0;
		 int count_1=0;
		 int max=0;
	        for(int k=0;k<nums.length;k++)
	        {
	        	System.out.println("current "+i);
	        	
	        	
	        	while(i<nums.length && nums[i]!=1)
	        	{
	        		count_0++;
	        		i++;
	        	}
	        		System.out.println("count_0 : "+count_0);
	        	
	        	j=i;
	        	while(count_1<=count_0 && nums[j]!=0) {
	        		count_1++;
	        	j++;
	        	}
	        	
	        	System.out.println(" j "+j);
	        	System.out.println("count_1 : "+count_1);
	        	if(count_0==count_1)
	        	{
	        		System.out.println("same");
	        		max+=count_0+count_1;
	        		
	        		i+=(count_0+count_1);
	        		i--;
	        		count_1=0;
	        		count_0=0;
	        	
	        	}
	        	else
	        	{
	        		count_1=0;
	        		count_0=0;
	        	}
	        }
	        System.out.println("max "+max);
		 
		 return 0;
		 
	    }

}
