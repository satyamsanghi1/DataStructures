package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1143_LongestCommonSubsequence {
	
	public static void main(String[] args) {
		String text1="cab";
		String text2="abac";
		
			
		int x=longestCommonSubsequenceAlter(text1, text2);
		
		System.out.println("ans "+x);
		
	}
	
	 public static int longestCommonSubsequenceAlter(String text1, String text2) {
		 
		 //time (O)NM
		 //space Min(n,m)
		 String small=text1.length()<text2.length()?text1:text2;
			String big=text2.length()>text1.length()?text2:text1;
			
			System.out.println("small "+small+" big "+big);
			System.out.println("small length "+small.length());
			int []even=new int[small.length()+1];
			int []odd=new int[small.length()+1];
			
			int []current=null;
			int []prev=null;
			
			for(int i=1;i<big.length()+1;i++)
			{
				
				for(int j=1;j<small.length()+1;j++)
				{
					
					if(i%2==0)
					{
						current=even;
						prev=odd;
					}
					else
					{
						current=odd;
						prev=even;
					}
					int a=prev[j];
					int b=current[j-1];
					if(big.charAt(i-1)==small.charAt(j-1))
					{
					
					current[j]=prev[j-1]+1;
							
					}
					else 
					{	
						
					current[j]=Math.max(a, b);
					}
				}
				traverse(current);
				}
			System.out.println("--------------------------");
			System.out.println("odd ");
			traverse(odd);
			System.out.println("even ");
			traverse(even);
			
			
			if(big.length()%2==0)
			{
				System.out.println("even length");
				return even[small.length()];
			}
			else
			{
				System.out.println("odd length ");
				return odd[small.length()];
			}
		 
	 }
	 public static int longestCommonSubsequence(String text1, String text2) {
			// time -> (O) N*M 
			// space -> (O)N*M
			//+1 for base case
			int dp[][]=new int [text2.length()+1][text1.length()+1];
			
			
			for(int i=1;i<text2.length()+1;i++)
			{
				System.out.println("at "+text2.charAt(i-1));
			
				for(int j=1;j<text1.length()+1;j++)
				{
					
					int a=dp[i-1][j];
					int b=dp[i][j-1];
					if(text2.charAt(i-1)==text1.charAt(j-1))
					{
					//if the last characters match then 
					/*copy the LCS without that character +1 
					 *eg : ABC , AC . last char is C , hence we Add LCS of AB and A to C
					 * 
					 */
					dp[i][j]=dp[i-1][j-1]+1;
							
					}
					else 
					{	
						//if not match than
						/*we look upwards [i-1][j] and left [i][j-1] which is greatrer 
						 * eg : abc,ab  last char c and b dont match 
						 * case 1 : upwards , means by removing c(row) that remains :
						 * 			ab , ab , 2 is the LCS 
						 * 
						 * Case 2 : left , means removing b in ab ,-> a
						 * 			abc and a - LCS ->1
						 * 
						 *  Hence Case 1 has higher lCS , so we chose Case 1 
						 * 
						 */
					dp[i][j]=Math.max(a, b);
		
					
					}
				}
				traverse(dp[i]);
				
				System.out.println("--------------------------");
			}
			
			return dp[text2.length()][text1.length()];
		}
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }

}
