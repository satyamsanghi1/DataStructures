package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString3 {
	//Algoexpert solution 2


	//leetcode 151 without having space length scenerio
	public static void main(String[] args) {

		//first we will reverse the whole string 
		//and after that reverse only the words
		
		String string="AlgoExpert is the best!";

		String str=reverseWordsInString(string);
		System.out.println("ans "+str);
	}
	public static String reverseWordsInString(String string) {


		char arr[]=string.toCharArray();
		
		reverse(arr,0,arr.length-1);
		int endOfWord=0;
		int startOfWord=0;
		
		while(true)
		{
			endOfWord=startOfWord;
			
			while(endOfWord<arr.length && arr[endOfWord]!=' ')
			{
				endOfWord++;
			}
			
			if(endOfWord==arr.length)
			{
				//when string end with a word
				reverse(arr, startOfWord,arr.length-1);
				break;
			}
			
			/*
			 * endOfWord -1 because of two reasons;
			 * if the word contains some chars our end of word is at next char i.e. space
			 * so we want to reverse only the word hence -1
			 * 
			 * other reason is,
			 * 
			 * if there are multiple spaces like "     algoexpert"
			 * then endOfWord will not increment , and will stay equal to start of word
			 * 
			 * the string will not reverse as we are passing endOfWord-1
			 * 
			 * 
			 */
			reverse(arr, startOfWord, endOfWord-1);
			//next word should start to the next char of endofWord
			startOfWord=endOfWord+1;
		}
		
		return new String(arr);
	}
	public static void reverse(char []array,int start,int end)
	{
		while(start<end)
		{
			char c=array[start];
			array[start]=array[end];
			array[end]=c;
			start++;
			end--;
		}
	}

}
