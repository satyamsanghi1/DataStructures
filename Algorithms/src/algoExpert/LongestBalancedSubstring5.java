package algoExpert;

import java.util.Stack;

public class LongestBalancedSubstring5 {

	/*Leetcode 32 
	 * AlgorExpert solution 3 making reusable the prev Solution
	 * (O)N Time , (O) 1 space
		100%Fast
	 */
	public static void main(String[] args) {

		/*
		 * REUSABLE CODE ADDING
		 *Using  two property of balanced parenthisis substring
		 *look from right->left 
		 * 1-> closing parenthises cannot match with opening , if opening come after it
		 * 		eg -> )(
		 * 
		 * look from left -> right
		 * 2-> opening parenthesis cannot match with closing , if closing comes before it 
		 * 		eg-> )(
		 */
		String string="(()";

		int ans=longestBalancedSubstring(string);
		System.out.println("ans "+ans );
	}


	public static int longestBalancedSubstring(String str)
	{
		return Math.max(getLongestBalancedStringInDirection(str,true),
			getLongestBalancedStringInDirection(str,false));
	}
	
	public static int getLongestBalancedStringInDirection(String str,boolean leftToRight)
	{
		int maxLength=0;
		int openingCount=0;
		int closingCount=0;
		//for right ->left , opening bracket becomes ) 
		char openingParens=leftToRight ? '(' : ')';
		
		int startIdx=leftToRight ? 0 : str.length()-1;
		
		int step=leftToRight ? 1 : -1;
		
		int idx=startIdx;
		
		while(idx>=0 && idx<str.length())
		{
			System.out.println("idx "+idx);
			if(str.charAt(idx)==openingParens)
				openingCount++;
			else
				closingCount++;
			
			if(closingCount>openingCount)
			{
				openingCount=0;
				 closingCount=0;
			}
			if(openingCount==closingCount)
			{
				maxLength=Math.max(maxLength,(openingCount+closingCount));
			}
			idx+=step;
			System.out.println("opening "+ openingCount+" closing "+closingCount+" max "+maxLength);
			System.out.println("------------");
		}
		
		return maxLength;
	}

}
