package algoExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LongestCommonSubsequence {
	//leetcode 1143,1092
	public static void main(String[] args) {
		
		String str1="abac";
		String str2="cab";
		
		List<Character>ans=longestCommonSubsequenceAlter(str1, str2);
		System.out.println("ans "+ans);
	}
	public static List<Character> longestCommonSubsequenceAlter1(String str1, String str2) {
		//SOLUTION 3
		// this olution is same as finding the LCS like leetcode
		// the logic to create lies in generateSequence() method
		int dp[][]=new int [str2.length()+1][str1.length()+1];
		
	      StringBuilder sb=new StringBuilder();

		for(int i=1;i<str2.length()+1;i++)
		{
			
		
			for(int j=1;j<str1.length()+1;j++)
			{
				
				int a=dp[i-1][j];
				int b=dp[i][j-1];
				if(str2.charAt(i-1)==str1.charAt(j-1))
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
	
		return buildSequence(dp,str1);
	}
	public static List<Character> buildSequence(int dp[][],String str1)
	{
	/* here we are passing our generated matrix and the String str1 which represents the column
		we will backtrack from bottom right corner of matrix to find our solution
	
	*/
		
		List<Character>sequence=new ArrayList<>();
		int i=dp.length-1;
		int j=dp[0].length-1;
		//if i or j becomes 0 that means they have reached base case
		//that time we should terminate our loop
		while(i!=0 && j!=0)
		{
			//if current is equal to above value in matrix is equal than move above
			if(dp[i][j]==dp[i-1][j])
			{
				i--;
			}
			//if current is equal to left value in matrix is equal than move left
			else if(dp[i][j]==dp[i][j-1])
			{
				j--;
			}
			//we move diagonally upwards and add charcter of that particular column to 
			// our list os LCS 
			else
			{
				sequence.add(0,str1.charAt(j-1));
				i--;
				j--;
			}
		}
		
		return sequence;
	}
	public static List<Character> longestCommonSubsequenceAlter(String str1, String str2) {
		//SOLUTION 2
		
		/*{0,0,0,0} this is array is created for every index in matrix 
		 * 
		 * 1st position represents the value or the character that is included in the LCS
		 * 2nd pos : represents the max length of LCS
		 * 3rd pos : represensts  the prev i value (above value)
		 * 4th pos :represents the prev j value (left value)
		 */
		int dp[][][]=new int[str2.length()+1][str1.length()+1][];
		
		//base cases
		for(int i=0;i<str2.length()+1;i++)
		{
			for(int j=0;j<str1.length()+1;j++)
			{
				dp[i][j]=new int[] {0,0,0,0};
			}
		}
		for(int i=1;i<str2.length()+1;i++)
		{
			System.out.println("at "+str2.charAt(i-1));
				
			for(int j=1;j<str1.length()+1;j++)
			{
				//if value is equal than 
				// include the current character at pos 1 ,
				// copy the max LCS value by going diagonally upwards +1
				// update the prev i : i-1
				// update the prev j : j-1
				if(str2.charAt(i-1)==str1.charAt(j-1))
				{
					dp[i][j]= new int[]{(int)str2.charAt(i-1),dp[i-1][j-1][1]+1,i-1,j-1};
				}
				//if not equal
				else
				{	/*put the -1 at value place because chars are not equal
					there could be 2 cases :
					CAse 1: when above maxLCS  is greater than left maxLCs i.e. 2nd value in the array
							update prev I as the i-1 since above is greater
							update prev J as current j, 
							
					CAse 2: when left maxLCS  is greater above left maxLCs i.e. 2nd value in the array
							update prev I as the i 
							update prev J as current j-1 since left is greater, 
					*/
					if(dp[i-1][j][1]>dp[i][j-1][1])
						 {
						//case 1 
							 dp[i][j]= new int[]{-1,dp[i-1][j][1],i-1,j};
						 }
						 else
						 {
							 //case 2 
							 dp[i][j]=new int[] {-1,dp[i][j-1][1],i,j-1};
						 }
				}
				
			}
			//traverse1(dp[i]);
			
		}
		return buildSequence(dp);
	
	}
	
	public static List<Character> buildSequence(int dp[][][])
	{
		// we have created this matrix with array of 4 values in each index which 
		//represents path to our lcs we have to traverse or backtrack to form our LCS
		
		List<Character>sequence=new ArrayList<>();
		//starting with bottom right corner of the matrix
		int i=dp.length-1;
		int j=dp[0].length-1;
		
		while(i!=0 && j!=0)
		{
			int[] current=dp[i][j];
			// if value is not equal to -1 , than add to list of LCS since we 
			//added -1 when we didnot found the chars match
			if(current[0]!=-1)
				sequence.add((char)current[0]);
			
			System.out.println("("+i+","+j+")");
			i=current[2];
			j=current[3];
		}
		
		
		 Collections.reverse(sequence);
		 
		 
		 return sequence;
	}

		public static List<Character> longestCommonSubsequence(String str1, String str2) {
			//SOLUTION 1
			// time -> (O) N*M *Min(N,M)
			// space -> (O)N*M*Min(N,M)
			
			//extra Min(n,m) because of concatenation task
			/* eg : abc + a takes (O)4  this is extra time
			 * 
			 */
			//+1 for base case
			String dp[][]=new String [str2.length()+1][str1.length()+1];
		
			//base cases
		  for(int i=0;i<str1.length()+1;i++) dp[0][i]="";
		  
		  for(int i=0;i<str2.length()+1;i++) dp[i][0]="";
		 
			
			for(int i=1;i<str2.length()+1;i++)
			{
				System.out.println("at "+str2.charAt(i-1));
			
				for(int j=1;j<str1.length()+1;j++)
				{
					
					String a=dp[i-1][j];
					String b=dp[i][j-1];
					if(str2.charAt(i-1)==str1.charAt(j-1))
					{
					//if the last characters match then 
					/*copy the LCS without that character +current character 
					 *eg : ABC , AC . last char is C , hence we Add LCS of AB and A to C
					 * 
					 */
						//taking extra time
					dp[i][j]=dp[i-1][j-1]+str2.charAt(i-1);
							
					}
					else 
					{	
						//if not match than
						/*we look upwards [i-1][j] and left [i][j-1] which is greatrer 
						 * eg : abc,ab  last char c and b dont match 
						 * case 1 : upwards , means by removing c(row) that remains :
						 * 			ab , ab , ab is the LCS 
						 * 
						 * Case 2 : left , means removing b in ab ,-> a
						 * 			abc and a - LCS ->a
						 * 
						 *  Hence Case 1 has higher lCS , so we chose Case 1 
						 * 
						 */
					dp[i][j]=a.length()>b.length()?a:b;
		
					
					}
				}
				traverse(dp[i]);
				
				System.out.println("--------------------------");
			}
			List<Character>list=new ArrayList<>();
			for(char c:dp[str2.length()][str1.length()].toCharArray())
				list.add(c);
			
				return 	 list;
		}
	 public static void traverse(String []nums)
	 {
		 System.out.println();
		 for(String l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }
	 public static void traverse1(int [][]nums)
	 {
		 System.out.println();
		 for(int[]l:nums)
			 System.out.print(l[0]+" ");
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
