package leetcode;

public class _674_LongestContinousIncreasingSubsequence {
	
	public static void main(String[] args) {
		
	int nums[]= {1};
	
	findLengthOfLCIS(nums);
	}
	 public static int findLengthOfLCIS(int[] nums) {

		
		 int a=1;
		 int b=0;
		 int max=1;
		 for(int i=1;i<nums.length;i++)
		 {
			if(nums[i-1]<nums[i])
			{
				a++;
			}
			else
			{
				a=1;
			}
			System.out.println("a "+a);
			
			if(a>max)
				max=a;
			
		 }
		 System.out.println("ans "+max);
	        return max;
	    }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }


}
