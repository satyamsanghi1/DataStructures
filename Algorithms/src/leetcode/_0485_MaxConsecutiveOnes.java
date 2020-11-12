package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class _0485_MaxConsecutiveOnes {
	public static void main(String[] args) {

		int nums[]= {1,1,0,1,1,1,0,1,1};
		findMaxConsecutiveOnes(nums);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		int count=0;
		int max=0;
	
		for(int i=0;i<nums.length;i++)
		{
			System.out.println("i "+i);
			if(nums[i]==1)
			{
				count++;
			}
			 if(i==nums.length-1 || nums[i]==0  )
			{
				System.out.println("here "+count);
				if(max<count)
				{
					max=count;
				}
				count=0;
			}

		}	
		System.out.println("count "+count);
	//	if(count==nums.length)
	//	return count;


		System.out.println("max "+max);
		return 0;
	}
}
