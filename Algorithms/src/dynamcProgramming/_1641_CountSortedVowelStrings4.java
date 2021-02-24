package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _1641_CountSortedVowelStrings4 {
	 static List<Character>data=new ArrayList<>(Arrays.asList('a','e','i','o','u'));
	 //32%Fast

	public static void main(String[] args) {

		int x='z';
		System.out.println(x-'a');
	
	countVowelStrings(3);
	}
	public static int countVowelStrings(int n) {

		int total=0;
		int [][]dp=new int [n+1][26];
		
		for(char c:data)
		{
			dp[1][c-'a']=1;
		}
		for(char c:data)
		{
			total+=count(n, c,dp);
			System.out.println("------------");
		}
		System.out.println("total "+total);
		return total;
	}
	
	public static int count(int n,char c,int dp[][])
	{
		System.out.println("n "+n+" c "+c);
		if(dp[n][c-'a']>0)
		{
			System.out.println("found");	
			return dp[n][c-'a'];
		}
		
		if(n==1)
			return 1;
		
		
		for(char z:data)
		{
			if(z>=c)
			{
				dp[n][c-'a']+=count(n-1,z,dp);
				
			}
		}
		
		return dp[n][c-'a'];
	}
	
}
