package algoExpert;

import java.util.Stack;

public class LongestBalancedSubstring4 {

	/*Leetcode 32 
	 * AlgorExpert solution 3 
	 * (O)N Time , (O) 1 space
		100%Fast
	 */
	public static void main(String[] args) {

		/*
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
		int maxLength=0;
		int openingCount=0;
		int closingCount=0;

		System.out.println("left-> right ");
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(')
			{
				openingCount++;
			}
			else
			{
				closingCount++;
			}
			if(closingCount>openingCount)
			{
				openingCount=0;
				closingCount=0;
			}	
			if(openingCount==closingCount)
				maxLength=Math.max(maxLength,(closingCount+openingCount));

			System.out.println("opening "+openingCount+" closing "+closingCount+" max "+maxLength);
		}
		
		 openingCount=0;
		 closingCount=0;
		System.out.println("right->left ");
		//because of eg -> (()
		for(int i=str.length()-1;i>=0;i--)
		{
			if(str.charAt(i)==')')
			{
				closingCount++;
			}
			else
			{
				openingCount++;
				
			}
			if(openingCount>closingCount)
			{
				openingCount=0;
				closingCount=0;
			}	
			if(openingCount==closingCount)
				maxLength=Math.max(maxLength,(closingCount+openingCount));

			System.out.println("opening "+openingCount+" closing "+closingCount+" max "+maxLength);
		}


		return maxLength;
	}

}
