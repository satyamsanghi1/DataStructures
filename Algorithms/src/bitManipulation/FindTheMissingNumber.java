package bitManipulation;

public class FindTheMissingNumber {
	
	public static void main(String[] args) {
		
		int nums[]= {1,2,4};
		
		missingNumber(nums);
	}
	
	public static int missingNumber(int[] nums)
	{
		int a=0;
		for(int i=1;i<=nums.length+1;i++)
		{
			a^=i;
			
		}
		System.out.println(a);
		int b=0;
		for(int i=0;i<nums.length;i++)
		{
			b^=nums[i];
			
		}
		System.out.println(b);
		System.out.println("ans "+(a^b));
		return 0;
	}

}
