package algoExpert;

import java.util.Stack;

public class LongestBalancedSubstring {

	/*Leetcode 32 
	 * 71%Fast my solution
	 * 
	 */
	public static void main(String[] args) {



	}
	public int longestValidParentheses(String s) {

		Stack<Integer> stack=new Stack<>();

		char c[]=s.toCharArray();
		//string windows having balanced pair of parenthesis with end as index , start as value
		int []dp=new int [s.length()];
		//i->windowEnd , dp[i]->windowStart ,storing the reverse window
		for(int i=0;i<dp.length;i++)
			dp[i]=Integer.MIN_VALUE;

		// each i -> [end][start]
		int max=0;
		for(int i=0;i<s.length();i++)
		{
			if(c[i]=='(')
			{
				stack.push(i);
			}
			else
			{
				if(!stack.isEmpty() && c[stack.peek()]=='(')
				{
					// compare the window
					int currentWindow=0;
					int start=stack.pop();
					int prevWindowStart=Integer.MIN_VALUE;
					if(start-1>=0)
						prevWindowStart=dp[start-1];

					if(prevWindowStart!=Integer.MIN_VALUE)
					{//last window and current window are adjacent
						currentWindow=(i-prevWindowStart)+1;
						//joining window and storing
						dp[i]=prevWindowStart;
					}
					else
					{
						currentWindow=(i-start)+1;
						dp[i]=start;
					}
					max=Math.max(max,currentWindow);
				}
			}

		}

		return max;

	}
}
