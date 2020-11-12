package dynamcProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		
		int nums[]= {3,4,7,6};
		
		canPartition2(nums);
	}
	 public static boolean canPartition(int[] nums) {
	        //33% Fast
		// Arrays.sort(nums);
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		 
		 char dp[][]=new char[nums.length+1][sum/2+1];
		 
		 //base case first column true
		 
		 for(int i=0;i<dp[0].length;i++)
		 {
			 dp[0][i]='F';
		 }
		 
		 for(int i=0;i<dp.length;i++)
		 {
			 dp[i][0]='T';
		 }
		 
		 
		 for(int i=1;i<dp.length;i++)
		 {
			 for(int j=0;j<dp[0].length;j++)
			 {
				 
				 dp[i][j]='F';
				if(j>=nums[i-1])
				{
					char value=dp[i-1][j-nums[i-1]];
					if(value=='T')
						dp[i][j]='T';
					else
						dp[i][j]=dp[i-1][j];
						
				//	System.out.println("value "+value);
					
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			 }
			 traverse(dp[i]);
		 }
		//boolean ans= generate(dp,nums,sum/2);
		 /*
		  * We dont need to find the sum of list numbers that dont include in the
		  * sum (using generate method).if last element in dp is true  ,then there are no whose sum is half 
		  * and it is obvious other elemnt would sum to other half 
		  * hence we can directly check the result
		  * 
		  * we  can use boolean array instead of char multidimensional array
		  * eg 2,4,4
		  */
		 traversedp(dp);
		 if(dp[dp.length-1][dp[0].length-1]=='T')
	            return true;
	        else
	            return false;
		
		 //return false;
	    }
	 public static boolean canPartition1(int[] nums) {
		 //70% fast
		 /*
		  * We could further optimize above approach.
		  *  We must understand that for any array element i,
		  *   we need results of the previous iteration (i-1) only. 
		  *   Hence, we could achieve the same using a one-dimensional array as well
		  *   
		  *   explanation why we are going from right to left 
		  *   https://www.youtube.com/watch?v=vZtCKL_OwdA 
		  */
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		  if( sum%2!=0)
	            return false;
		  
		 boolean []dp=new boolean [sum/2+1];
		 System.out.println(dp.length);
		 //base case
		 dp[0]=true;
		 
		 for(int i=0;i<nums.length;i++)
		 {
			 for(int j=dp.length-1;j>=nums[i];j--)
			 {
				 if(!dp[j])
				 {
					 boolean complement=dp[j-nums[i]];
					 if(complement)
						 dp[j]=true;
				 }
			 }
		 }
		 System.out.println("ans "+dp[dp.length-1]);
		 return false;
	 }
	 public static boolean canPartition2(int[] nums) {
		 //top down approach
		 /*
		  * intuition and diagram mentioned in solution of this problem
		  * Time Limit Exceeeded
		  */
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		  if( sum%2!=0)
	            return false;
		  
	
		// boolean ans=helper(nums,0, sum/2,false);
		 //System.out.println("ans "+ans);
		 
		 Boolean memo[][]=new Boolean [nums.length][sum/2+1];
		 boolean ans=helper(nums,0, sum/2,memo);
		 System.out.println("ans "+ans);
		 return false;
	 }
	 public static boolean helper(int []nums,int i,int sum,boolean included)
	 {
		
		 if(sum==0)
			 return true;
		 if(sum<0 || i>=nums.length)
			 return false;
		 
		 
			 System.out.println("included "+nums[i]+" sum "+(sum-nums[i]));

			if( helper(nums,i+1,sum-nums[i],true))
				return true;
			
		 
			 System.out.println("not included "+nums[i]+" sum "+sum);
			
			 return (helper(nums,i+1,sum,false));
				
		
		 
	 }
	 public static boolean helper(int []nums,int i,int sum,Boolean[][]memo)
	 {
		// top down approach with memoization
		 //86% Fast
		 if(sum==0)
			 return true;
		 if(sum<0 || i>=nums.length)
			 return false;
		 
		 if(memo[i][sum]!=null)
		 {
			return memo[i][sum]; 
		 }
		boolean a=false,b=false;
		 
			 System.out.println("included "+nums[i]+" sum "+(sum-nums[i]));

			 a=helper(nums,i+1,sum-nums[i],memo);
				
			
		 
			 System.out.println("not included "+nums[i]+" sum "+sum);
			b=helper(nums,i+1,sum,memo);
				
			boolean result=a||b ;
			memo[i][sum]=result;
		return result;
		 
	 }
	
		 
	 public static boolean generate(char [][]dp,int []nums,int sum2)
	 {
		 //no need
		 List<Integer>list=new ArrayList<>();
		 HashSet<Integer>set=new HashSet<>();
		 int i=dp.length-1;
		 int j=dp[0].length-1;
		 int sum=0;
		 int sum1=0;
		 while(j>0 && i>0)
		 {
			
			 System.out.println("i "+i+" j "+j);
			 if(dp[i][j]==dp[i-1][j])
			 {
				 sum+=nums[i-1];
				 i--;
				
			 }
			 else
			 {
				 System.out.println("adding "+nums[i-1]);
				 sum1+=nums[i-1];
				 list.add(i-1);
				 set.add(i-1);
				 j-=nums[i-1];
				 i--;
				
			 }
			 System.out.println("i "+i+" j "+j);
			
			 System.out.println("---------------------");
			 System.out.println("sum "+sum+" , sum1 "+sum1);
		 }
		 System.out.println(list);
		return sum2==sum;
	 }
	  public static void traverse(char a[])
	  {
		  for(char i:a)
		  {
			  System.out.print(i+" ");
		  }
		  System.out.println();
	  }
	  public static void traversedp(char a[][])
	  {
		for(int i=0;i<a.length;i++)
		{
			for(int k=0;k<a[0].length;k++)
				System.out.print(a[i][k]+" ");
			System.out.println();
		}
		  System.out.println();
	  }

}
