package leetcode;

public class _136_SingleNumber {
	
	///incomplete because it uses bit manipulation 
	
	// we have a solution which uses hashmap but space complexity is high
	
	public static void main(String[] args) {
		
		int a[]= {4,1,2,1,2};
		int candidate =singleNumber(a);
		System.out.println(candidate);
		
	}

	
	public static int singleNumber(int[] nums) 
	{
		int count=0;
		int candidate=0;
		for(int i=0;i<nums.length;i++)
		{
			if(count==0)
			{
				candidate=nums[i];
				count=1;
			}
			if(candidate!=nums[i])
			{
				count++;
			}
			else
			{
				count--;
			}
		}
		
		return candidate;
	}

}