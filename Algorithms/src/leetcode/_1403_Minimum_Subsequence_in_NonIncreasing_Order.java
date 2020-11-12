package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1403_Minimum_Subsequence_in_NonIncreasing_Order {
	
	public static void main(String[] args) {
		
		 int a[]= {4,3,10,9,8};
		
		//int a[]= {8,8};
		minSubsequence(a);
		
	}
	public static List<Integer> minSubsequence(int[] nums) 
	{
		///applying counting sort 

		int arr[]=new int[100];
		int output[]=new int[nums.length];
		
		for(int i=0;i<nums.length;i++)
		{
			arr[nums[i]]++;
		}
		for(int p:arr)
			System.out.print(p+" ");
		System.out.println();
		for(int i=0;i<arr.length-1;i++)
		{
			arr[i+1]=arr[i]+arr[i+1];
		}
		
		for(int p:arr)
			System.out.print(p+" ");
		
		for(int i=0;i<nums.length;i++)
		{
			output[--arr[nums[i]]]=nums[i];
		}
		System.out.println();
		for(int p:output)
			System.out.print(p+" ");
        ArrayList<Integer>ans=new ArrayList<>();
        
		int sum=sum(nums);
		
		//Arrays.sort(nums);
		
		System.out.println("sum "+sum);
		int complimentSum=0;
		
		int q=nums.length-1;
		while(complimentSum<=sum-complimentSum)
		{
			
			System.out.println("call");
			
		//		int x=Collections.max(arr);
			int x=output[q];
			
			System.out.println("max "+x);
			ans.add(x);
		
			complimentSum+=x;
			
			q--;
		}
		Collections.sort(ans,Collections.reverseOrder());
		System.out.println("list "+ans);
		System.out.println("compliment "+complimentSum);
			
		return null;
    }
	
	public static int sum(int a[])
	{
		int sum=0;
		
		for(int x:a)
			sum+=x;
		return sum;
	}
}
