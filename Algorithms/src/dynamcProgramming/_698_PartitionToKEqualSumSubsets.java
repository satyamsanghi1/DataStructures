package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _698_PartitionToKEqualSumSubsets {
	
	public static void main(String[] args) {
		
		int nums[]= {10,10,10,7,7,7,7,7,7,6,6,6};
		
		canPartitionKSubsets(nums,4);
	}
	 public static boolean canPartitionKSubsets(int[] nums, int k) {
	    
		 int sum=0;
		 for(int i:nums)
			 sum+=i;
		 
		 System.out.println("total sum "+sum);
		 int eachSum=sum/k;
		 System.out.println("each sum "+eachSum);
		 
		
		 
		 helper(nums, k,eachSum);
		 return false;
	    }
	 public static void helper(int []nums,int k,int sum)
	 {
		 List<Integer>values=new ArrayList<>();
		 for(int i:nums)
		 {
			 values.add(i);
		 }
		 
		
		 boolean dp[][]=new boolean [values.size()+1][sum+1];
		 System.out.println("sum "+sum);
		
		 int  x=0;
		 while(x<k || values.size()>0)
		 {
			 System.out.println("values "+values);
			  dp=new boolean [values.size()+1][sum+1];
			  List<Integer>subset=helper1(dp,values);
			  for(int i:subset)
			  {
				  values.remove(i);
			  }
			  if(subset.size()==0)
				  break;
			  x++;
		 }
		 System.out.println("x "+x);
		 
	 }
	 
	 public static List<Integer> helper1(boolean dp[][],List<Integer> nums)
	 {
		 dp[0][0]=true;
		 for(int i=1;i<dp.length;i++)
		 {
			 dp[i][0]=true;
			 for(int j=0;j<dp[0].length;j++)
			 {
				 
				 if(nums.get(i-1)<=j)
				 {
					 
					 dp[i][j]=dp[i-1][j-nums.get(i-1)]|| dp[i-1][j];
				 }
				 else
				 {
					 dp[i][j]=dp[i-1][j];
				 }
			 }
			 traverse1(dp[i]);
		 }
	
		 System.out.println(dp[dp.length-1][dp[0].length-1]);
		return generateSubset(dp, nums);
	 }
	 public static List<Integer> generateSubset(boolean dp[][],List<Integer> nums)
	 {
		 traverse(dp);
		 int i=dp.length-1;
		 int j=dp[0].length-1;
		 List<Integer>set=new ArrayList<>();
		 
		 while(i>0)
		 {
			 System.out.println("i "+i+" j "+j+" val "+dp[i][j]);
			 if(dp[i-1][j]==dp[i][j])
			 {
				 i--;
			 }
			 else
			 {
				 System.out.println("adding "+nums.get(i-1));
				 set.add(i-1);
				 j=j-nums.get(i-1);
				 i--;
				
			 }
		 }
		 System.out.println(set);
		 return set;
	 }
	 public static void traverse(boolean dp[][])
	 {
		 for(int i=0;i<dp.length;i++)
		 {
			 for(int j=0;j<dp[0].length;j++)
			 {
				 if(dp[i][j])
					 System.out.print("T");
				 else
					 System.out.print("F");
			 }
			 System.out.println();
		 }
	 }
	 public static void traverse1(boolean dp[])
	  {
		  for(boolean i:dp)
		  {
			  if(i)
					 System.out.print("T");
				 else
					 System.out.print("F");
		  }
		  System.out.println();
	  }

}
