package slidingWindow;

public class _152_MaximumProductSubArray {
	/*
	 * REFERENCE : https://www.youtube.com/watch?v=vtJvbRlHqTA
	 * 
	 */
	
	public static void main(String[] args) {
		
		int nums[]= {-1,6,2,0,7,9};
		System.out.println("answer "+maxProduct(nums));
	}
	/*
	 * if keep track of only max product 
	 * 
	 */
	 public static int maxProduct(int[] nums) {
	        
		 
		 
			int prev_maxProduct=nums[0];
			int prev_minProduct=nums[0];
			
			int current_maxProduct=nums[0];
			int current_minProduct=nums[0];
			int answer=nums[0];
			
			for(int i=1;i<nums.length;i++)
			{
				current_maxProduct=Math.max(prev_maxProduct*nums[i],prev_minProduct*nums[i]);
				current_maxProduct=Math.max(current_maxProduct,nums[i]);
				
				current_minProduct=Math.min(prev_maxProduct*nums[i],prev_minProduct*nums[i]);
				current_minProduct=Math.min(current_minProduct,nums[i]);
				
				System.out.println("curernt max "+current_maxProduct);
				System.out.println("current min "+current_minProduct);
				
				answer=Math.max(current_maxProduct,answer);
				
				prev_maxProduct=current_maxProduct;
				prev_minProduct=current_minProduct;
				
				System.out.println("--------------------------");
			}
			 
			
			 return answer;
	    }

}
