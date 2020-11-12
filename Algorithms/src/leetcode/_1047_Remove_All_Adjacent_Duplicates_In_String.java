package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _1047_Remove_All_Adjacent_Duplicates_In_String {
	
	public static void main(String[] args) {
		
		String s="abbaca";
		
		removeDuplicates(s);
		
	}
	
	public static String removeDuplicatesAlter(String s)
	{
		//this solution much faster 
		
		StringBuilder sb=new StringBuilder(s);
		
		for(int i=0;i<sb.length()-1;i++)
		{
			System.out.print(sb.charAt(i)+" ");
			
			if(sb.charAt(i)==sb.charAt(i+1))
			{
				sb.delete(i,i+2);
			
				if(i>0)
					i=i-2;
				else if (i==0)
					--i;
			}
			
			System.out.println("length "+sb.length());
			System.out.println("i "+i);
		}
		
	
		
		
		System.out.println("answer "+sb);
		
		return null;
	}
	public static String removeDuplicates(String S)
	{
		Stack<Character>stack=new Stack<>();
		stack.toString();
	//System.out.println(stack.peek());
		//stack.push(S.charAt(0));
		for(int i=0;i<S.length();i++)
		{
			System.out.print("i "+ i);
			if(!stack.isEmpty())
			{
				if(stack.peek()==S.charAt(i))
				{
					stack.pop();
				}
				else
					stack.push(S.charAt(i));

			}
			else
				stack.push(S.charAt(i));
			
			System.out.println(stack);
		}
		String q="";
		for(char c:stack) {
			q+=c;
		}
			System.out.println(q);
		
		return null;
	}

}



















