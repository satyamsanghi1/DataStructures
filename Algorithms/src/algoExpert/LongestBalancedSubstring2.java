package algoExpert;

import java.util.Stack;

public class LongestBalancedSubstring2 {

	/*Leetcode 32 
	 * AlgorExpert solution 1 BruteForce 
	 * Create all substring of even length and check balanced or not
	 * 
	 * even because odd length will be unbalanced by default
	 */
	public static void main(String[] args) {



	}
	public int longestBalancedSubstring(String string) {
		// (O) N^3 time , (O) N Space
		int max=0;
		for(int i=0;i<string.length();i++)
		{
			for(int j=i+1;j<string.length();j+=2)
			{
				String sub=string.substring(i,j+1);
				if(isBalanced(sub))
				{
					max=sub.length()>max?sub.length():max;
				}
			}
		}
		return max;
	}
	public boolean isBalanced(String str)
	{
		Stack<Character>stack=new Stack<>();
		char c[]=str.toCharArray();

		for(int i=0;i<str.length();i++)
		{
			if(c[i]=='(')
			{
				stack.push('(');
			}
			else if(!stack.isEmpty())
				stack.pop();
			else 
				return false;
		}

		return stack.isEmpty();
	}

}
