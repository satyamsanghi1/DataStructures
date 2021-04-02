package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
	//mysolution working passing all testcases

	
	//leetcode 151 without having space length scenerio
	public static void main(String[] args) {

		
		
	}
	public static String reverseWordsInString(String string) {

		if(string.length()==0)
			return "";

		List<String>words=new ArrayList<String>();
		char c[]=string.toCharArray();
		int lastCharIdx=Integer.MIN_VALUE;
		int lastSpaceIdx=Integer.MIN_VALUE;

		for(int i=0;i<string.length();i++)
		{
			if(c[i]!=' ' && lastCharIdx==Integer.MIN_VALUE )
			{
				lastCharIdx=i;
			}
			if(c[i]==' ' && lastSpaceIdx==Integer.MIN_VALUE )
			{
				lastSpaceIdx=i;
			}
			if( i+1<c.length && c[i]!=' ' && c[i+1]==' ')
			{
				//counting words length
				words.add(0,string.substring(lastCharIdx,i+1));
				lastCharIdx=Integer.MIN_VALUE;
				lastSpaceIdx=i+1;
			}

			if(i+1<c.length && c[i]==' ' && c[i+1]!=' ')
			{
				//counting space length
				words.add(0,string.substring(lastSpaceIdx,i+1));
				lastSpaceIdx=Integer.MIN_VALUE;
			}
		}

		if(c[c.length-1]!=' ' )
		{
			//checking string ending with a word
			words.add(0,string.substring(lastCharIdx,c.length));
		}

		if(c[c.length-1] ==' ')
		{
			//checking string ending with a space
			words.add(0,string.substring(lastSpaceIdx,c.length));
		}
		System.out.println("list "+words );


		return String.join("",words);
	}

}
