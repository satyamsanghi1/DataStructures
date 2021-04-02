package algoExpert;

import java.util.Stack;

public class LongestBalancedSubstring3 {

	/*Leetcode 32 
	 * AlgorExpert solution 2 
	 * (O)N Time , (O) N space
	
	 */
	public static void main(String[] args) {

		/*
		 * storing the index of ( in stack
		 */
		String string="())()";

		int ans=longestBalancedSubstring(string);
		System.out.println("ans "+ans );
	}
	
	
	public static int longestBalancedSubstring(String str)
	{
		Stack<Integer>stack=new Stack<>();
		//previos index of any balanced substring
		//intially -1 
		stack.push(-1);
		char c[]=str.toCharArray();

		int max=0;
	
		for(int i=0;i<str.length();i++)
		{
			if(c[i]=='(')
			{
				stack.push(i);
			}
			else
			{
				
				stack.pop();
				if(stack.isEmpty())
				{
					// ) idx will act as starting index for any future balanced substrings
				stack.push(i);	
				}
				else
				{
					int startIdx=stack.peek();
					int size=i-startIdx;
					System.out.println("size "+size);
					max=Math.max(size,max);
				}
				
			}
		
			System.out.println(stack);
			System.out.println("-----------");
		}

		return max;
	}

}
