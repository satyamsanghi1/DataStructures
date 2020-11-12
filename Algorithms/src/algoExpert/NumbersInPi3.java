package algoExpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumbersInPi3 {
	//bottm Up working my solution
	 public static void main(String[] args) {
		

		 String pi="3141592";
		 
		 String numbers[]= {"3141",
				    "5",
				    "31",
				    "2",
				    "4159",
				    "9",
				    "42"
				    };
		 
		int ans=numbersInPi(pi, numbers); 
		System.out.println("ans "+ans);
		 
	}
	 public static int numbersInPi(String pi, String[] numbers) {
		 
		

		 Set<String>set=new HashSet<>();
		 for(String s:numbers)
		 {
			set.add(s);
		 }
		int ans= alter(pi,set);
		 
		 return ans;
	//	int ans= helper(pi,set ,cache, 0);
		//System.out.println("ans "+ans);
		//return ans==Integer.MAX_VALUE?-1:ans;
		  }
	 
	 public static int alter(String pi,Set<String>set)
	 {
		 int dp[]=new int [pi.length()];
		 Arrays.fill(dp,Integer.MAX_VALUE);;
		 for(int i=pi.length()-1;i>=0;i--)
		 {
			 
			 for(int k=i;k<pi.length();k++)
			 {
				 System.out.println(pi.substring(i,k+1));
				 if(set.contains(pi.substring(i,k+1)))
				 {
					 if(k==pi.length()-1)
					 {
						 dp[i]=0;
					 }
					 else
					 {
						 System.out.println("in--");
						 if(dp[k+1]!=Integer.MAX_VALUE)//max value overflow condition
						 dp[i]=Math.min(dp[k+1]+1,dp[i]);
						 else
							 dp[i]=Math.min(dp[k+1],dp[i]);
					 }
					 System.out.println("dp[i] "+dp[i]);
				 }
			 }
			 traverse(dp);
			 System.out.println("------------------");
			 
			 
			 
		 }
		 return dp[0]==Integer.MAX_VALUE?-1:dp[0];	 
		 }
	 
	
	 public static void traverse(int a[])
	 {
		 for(int o:a)
			 System.out.print(o+" ");
		 System.out.println();
	 }

}
