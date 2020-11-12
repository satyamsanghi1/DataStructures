package leetcode;

import java.util.Arrays;

public class _0016_3SumClosest {
	
	public static void main(String[] args) {
		
		
		/// using logic of calculating the distance from the difference of target sum and current sum		
		// if distance is shorter than current absolute distance , than update the minimum sum
		int[]a= {0,1,2};
		int target=1;
		int b=threeSumClosest(a, target);
		
		System.out.println("ans "+b);
	}
	 public static int threeSumClosest(int[] nums, int target) {
	        
	        int distance=Integer.MAX_VALUE;
	        int min_sum=0;
			Arrays.sort(nums);
			for(int i=0;i<nums.length-2;i++)
			{
				int current=nums[i];
				
				int left=i+1;
				int right=nums.length-1;
				while(left<right)
				{
					System.out.println("h "+nums[left]+" ,"+nums[right]+" ,"+current );

					int sum=nums[left]+nums[right]+current;
					System.out.println("sum "+sum);
					
					if(Math.abs(target-sum)<distance )
					{
						 distance=Math.abs(target-sum);
		                    min_sum=sum;
					}
					/*if( sum==target)
	                {
						System.out.println("here");
						min_sum=sum;
	                    left++;
	                    right--;
	                }*/
	                
					else if(sum<target)
						left++;
					else if(sum>target)
						right--;
					
				}
			}
	    return min_sum;
	    }

}
