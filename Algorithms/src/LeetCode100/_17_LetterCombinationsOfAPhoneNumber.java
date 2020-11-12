package LeetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber {
	 static HashMap<Character,String>phone=new HashMap<>();
	 static List<String>combs=new ArrayList<String>();
	public static void main(String[] args) {
		
		/*
		 * 
		 * TIme Complexity - 4^N , where 4 is the highest no of letters of a digit
		 * And N is the length of String of Digits input given
		 * 
		 * Space -> 4^N * N 
		 * where 4^N Solutions and N is The size of 1 string
		 */
		
		phone.put('2',"abc");
		phone.put('3',"def");
		phone.put('4',"ghi");
		phone.put('5', "jkl");
		phone.put('6', "mno");
		phone.put('7', "pqrs");
		phone.put('8', "tuv");
		phone.put('9', "wxyz");
		//letterCombinations("23");
		letterCombinationsAlter("23");
	}
	public static List<String> letterCombinations(String digits) {

		
		//List<String>combs=new ArrayList<String>();
		StringBuilder current=new StringBuilder();
		// current is the String in which we create combinations
		// and when size of current equals to size of digits we store a copy of current string
		
		helper(0, current,digits, combs);
		System.out.println(combs.size());
		System.out.println(combs);
		return combs;
    }
	public static List<String> letterCombinationsAlter(String digits) {
		// ITERATIVE SOLUTION
		/*
		 * Time complexoty same as REcursion 85% 
		 * Logic similar to SubSets Iterative solution
		 */
		
		combs.add("");
		for(char c:digits.toCharArray())
		{
			helperAlter(phone.get(c));
		}
		System.out.println(combs);
		return combs;
	}
	public static void helperAlter(String letters)
	{
		List<String>a=new ArrayList<>();
		for(char c:letters.toCharArray())
		{
			int size=combs.size();
			for(int i=0;i<size;i++)
			{
				StringBuilder sb=new StringBuilder(combs.get(i));
				sb.append(c);
				a.add(sb.toString());
			}
		}
		combs=a;
	}
	
	public static void helper(int i,StringBuilder current,String digits,List<String>combs)
	{
		/*
		 * RECURSIVE AND BACKTRACKING SOLUTION
		 */
		/*
		 *  i represents the current digit of a phone number 
		 *  and in this function call i represents digit in a particluar state of recursion
		 */
		// Time : M^N .N 
		char x = 0;
		System.out.println(x);
		// when i equals the size of digits 
		// we make copy of current and return 
		// return because here i is equal to length of digits and if we go further
		// the next step is to get digit at i , we will give index out of bound exception
		if(digits.length()==i)
		{
			System.out.println("here");
			combs.add(new String(current.toString()));
		return;
		}
		/*
		 * if(current.length()==digits.length())
		 * {
		 * combs.add(new String(current.toString()));
		 * }
		 *	
		 */
		 char currentDigit=0;
		 //checking if i exceeds the size of digits , because in call we are incrementing i
		/*	if(i<digits.length())
			{
				// finding the particular digit at that index i
			currentDigit=digits.charAt(i);
	        }
	        else
	            return;*/
		 currentDigit=digits.charAt(i);
		System.out.println("currentDigit " +currentDigit);
		// finding the String of letter of that digit using map in (O)1 Time
		String s=phone.get(currentDigit);
		
		// iterating through the String of chars of that particular digit at index i
		for(int k=0;k<s.length();k++)
		{
			// adding the first char to current combination
			current.append(s.charAt(k));
			/*
			 * going to next state with next digit ,as we have added 1 char from this digit's list
			 * 
			 */
			helper(i+1,current, digits, combs);
			/*
			 * When coming back , deleting the current char , so that our curent String
			 * can come back to previous state as it was earlier 
			 * and we can create or add next char ,(combination)
			 */
			current.deleteCharAt(current.length()-1);
		
		}
		
	}

}
