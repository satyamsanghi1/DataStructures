package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1408_StringMatchingInArray {
	
	static int count=0;
	public static void main(String[] args) 
	{
	
		String[]words={"mass","as","hero","superhero"};
		
char[] str="superhero".toCharArray();
		
		char[] value="hero".toCharArray();
		
		recur(str,0,str.length-1,value,0,value.length-1);
		
		
		
	}

	public List<String> stringMatching(String[] words)
	{
		List<String >list=new ArrayList<>();
		
		for(int i=0;i<words.length;i++)
		{
			for(int k=1;k<words.length;k++)
			if(words[i].length()>words[k].length())
			{
				
			}
		}
		
		return list;
		
		
    }
	
	public static void recur(char[]str,int i,int j,char []value ,int k,int q)
	{
		if(count==10)
			return ;
		System.out.println(str[i]);
		if(q==0 || k==value.length-1)
		{
			System.out.println("matched");
			return ;
		}
		if(str[i]!=value[k] && str[j]==value[q])
		{
			
			System.out.println("here");
			recur(str,i++,j--,value,k,q--);
		}
		
	}

}




































