package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString2 {
	//Algoexpert solution 1


	//leetcode 151 without having space length scenerio
	public static void main(String[] args) {



	}
	public static String reverseWordsInString(String string) {

		int startOfWord=0;
		List<String>words=new ArrayList<>();
		char c[]=string.toCharArray();
		for(int i=0;i<string.length();i++)
		{
			if(c[i]==' ')
			{
				words.add(0,string.substring(startOfWord,i));
				startOfWord=i;
			}
			else
			{
				//current char is a word and if start is space , then add
				if(c[startOfWord]==' '){
					words.add(0,string.substring(startOfWord,i));
					startOfWord=i;
				}
			}
		}
		words.add(0,string.substring(startOfWord,c.length));
		return String.join("",words);
	}

}
