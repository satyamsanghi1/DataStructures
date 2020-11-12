package dynamcProgramming;

public class _1092_ShortestCommonSuperSequence {
	
	public static void main(String[] args) {
		
	/*There are two solutions : 
	 * Solution 1 : we can build string for each subproblems 
	 * eg : abac,cab
	 * for a , c they are not equal hence we add them to make ac 
	 * hence we continue this to generate our final solution by filling the matrix
	 * 
	 * SOLUTION 2 : We can use LCS to find our solution .
	 * 	Just as we used build sequence method to generate LCS we can also use the same methods 
	 * to generate to generate shortest common supersequence
	 * 
	 *  
	 */
		String str2="abac";
		String str1="cab";
		
		String ans=shortestCommonSupersequence2(str1, str2);
		System.out.println("ans "+ans);
		
	}
	public static String shortestCommonSupersequence2(String str1, String str2) {
		//60%fast
		int [][]dp=longestCommonSubsequence(str2,str1);
		System.out.println("building ");
		System.out.println();
		buildSuperSequence(dp, str1, str2);
		return "";
	}
	public static String buildSuperSequence(int dp[][],String str1,String str2)
	{
		// PART 2 : Generating our solution using dp matrix formed using LCS
		int i=dp.length-1;
		int j=dp[0].length-1;
		StringBuilder sb=new StringBuilder();
		
		while(i!=0 || j!=0)
		{
			System.out.println("i "+i+",j "+j);
			// if above values is equal to current value in dp  means 
			// we have come down from above and there is no common char at this index
			// hence we add left valuefrom str1 as it is not equal and we move up
			if(i-1>=0 && dp[i][j]==dp[i-1][j])
			{
				
				System.out.println("up");
				sb.append(str1.charAt(i-1));
				i--;
			}//Similarly ,  if left values is equal to current value in dp  means 
			// we have come right from left and there is no common char at this index
			// hence we add above value from str2 as it is not equal and we move left
			else if(j-1 >=0 && dp[i][j]==dp[i][j-1])
			{
				System.out.println("left");
				sb.append(str2.charAt(j-1));
				j--;
			}
			else
			{ 	// if we found common char just add that char 
				// and move diagonally upwards
				sb.append(str2.charAt(j-1));
				i--;
				j--;
			}
			System.out.println(sb);
			System.out.println("-------------------");
		}
		sb.reverse();
		return sb.toString();
	}
	 public static int[][] longestCommonSubsequence(String text1, String text2) {
			
		 //SOLUTION 3 : PART 1  generateing LCS
			int dp[][]=new int [text2.length()+1][text1.length()+1];
			for(int i=1;i<text2.length()+1;i++)
			{
				for(int j=1;j<text1.length()+1;j++)
				{	
					int a=dp[i-1][j];
					int b=dp[i][j-1];
					if(text2.charAt(i-1)==text1.charAt(j-1))
					{
					dp[i][j]=dp[i-1][j-1]+1;		
					}
					else 
					{		
					dp[i][j]=Math.max(a, b);					
					}
				}
				traverse(dp[i]);
			}
			return dp;
		}
	public static String shortestCommonSupersequence1(String str1, String str2) {
		//5%time , 15 % space
		String small=str1.length()<str2.length()?str1:str2;
		String big=str2.length()>str1.length()?str2:str1;
		
		String []odd=new String[small.length()+1];
		String []even=new String[small.length()+1];
	
		String []current=null;
		String []prev=null;
		System.out.println("big "+big);
		for(int i=0;i<small.length()+1;i++)
		{
			even[i]="";
			odd[i]="";
		}
		for(int i=1;i<small.length()+1;i++)
			even[i]+=even[i-1]+small.charAt(i-1);
		
		
		traverse(even);
		
		
		for(int i=1;i<big.length()+1;i++)
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
			current[0]=prev[0]+big.charAt(i-1)+"";
			System.out.println("current[0] "+current[0]);
			System.out.println("at "+big.charAt(i-1));
			for(int j=1;j<small.length()+1;j++)
			{
				
				
				if(big.charAt(i-1)==small.charAt(j-1))
				{
					current[j]=prev[j-1]+big.charAt(i-1);
				}
				else
				{
					String above=prev[j]+big.charAt(i-1);
					String left=current[j-1]+small.charAt(j-1);
					System.out.println("above "+above +" ,left  "+left );
					
					current[j]=above.length()<left.length()?above:left;
				}
			}
			
			traverse(current);
			
			System.out.println("----------------------------------");
		}
		
		if(big.length()%2!=0)
		{
			return odd[small.length()];
		}
		else
		{
			return even[small.length()];
		}
		
	}
	public static String shortestCommonSupersequence(String str1, String str2) {
		//giving  Memory limit exceeded
		String dp[][]=new String[str2.length()+1][str1.length()+1];
		
		for(int i=0;i<str2.length()+1;i++)
		{
			for(int j=0;j<str1.length()+1;j++)
			{
				dp[i][j]="";
			}
		}
		for(int i=1;i<str1.length()+1;i++)
			dp[0][i]+=dp[0][i-1]+str1.charAt(i-1);
		
		for(int i=1;i<str2.length()+1;i++)
			dp[i][0]+=dp[i-1][0]+str2.charAt(i-1);
		
		
		for(int i=0;i<str1.length()+1;i++)
		System.out.println(dp[0][i]);
		
		for(int i=0;i<str2.length()+1;i++)
			System.out.println(dp[i][0]);
		
		for(int i=1;i<str2.length()+1;i++)
		{
			System.out.println("at "+str2.charAt(i-1));
			for(int j=1;j<str1.length()+1;j++)
			{
				dp[i][j]="";
				
				if(str2.charAt(i-1)==str1.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+str2.charAt(i-1);
				}
				else
				{
					String above=dp[i-1][j]+str2.charAt(i-1);
					String left=dp[i][j-1]+str1.charAt(j-1);
					System.out.println("above "+above +" ,left  "+left );
					dp[i][j]=above.length()<left.length()?above:left;
				}
			}
			traverse(dp[i]);
			System.out.println("----------------------------------");
		}
		
		
		return dp[str2.length()][str1.length()];
	}
	 public static void traverse(String []nums)
	 {
		 System.out.println();
		 for(String l:nums)
			 System.out.print(l+" , ");
		 System.out.println();
	 }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }

}
