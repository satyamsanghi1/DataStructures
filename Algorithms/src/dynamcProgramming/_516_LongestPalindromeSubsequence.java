package dynamcProgramming;

public class _516_LongestPalindromeSubsequence {
	
	// youtube : https://www.youtube.com/watch?v=yZWmS6CXbQc	
	public static void main(String[] args) {
		
		String s="cddb";
		System.out.println("ans "+longestPalindromeSubseq(s));	
	}
	/*Solution 1 : we can solve this question by usning LCS  : 
	 * We need just other String , which we can use by reversing the input string
	 * as String and reverse of string is called palindrome we can use this logic for 
	 * finding common subsequence in these two strings
	 * 
	 */
	public static 	int longestPalindromeSubseq(String s) {
		//59%Fast	SOLUTION 2
		
		int dp[][]=new int [s.length()][s.length()];
		
		for(int i=0;i<s.length();i++)
			dp[i][i]=1;
		
		for(int i=1;i<s.length();i++)
		{
			for(int j=0;j<s.length();j++)
			{
				if((i+j)<s.length())
				{
					if(s.charAt(i+j)==s.charAt(j))
					{
						System.out.println(s.charAt(j));
						dp[j][i+j]=dp[j+1][(i+j)-1]+2;
					}
					else
					{
						dp[j][i+j]=Math.max(dp[j][(i+j)-1],dp[j+1][(i+j)]);
					}
				System.out.println("("+j+","+(i+j)+") : = "+dp[j][i+j]);
					
				
				
				}
			}
			System.out.println("-----------------");
		}
		return dp[0][s.length()-1];
	}

}
