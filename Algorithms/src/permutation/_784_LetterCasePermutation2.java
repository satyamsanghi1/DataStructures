package permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _784_LetterCasePermutation2 {
	//without using stringBuilder
	//100%Fast
	public static void main(String[] args) {

		String s="a1b2";

		System.out.println(letterCasePermutation(s));
	}
	public static List<String> letterCasePermutation(String S) {

		

		
		char []s=S.toCharArray();
		List<String>val=new ArrayList<>();
	        StringBuilder sb=new StringBuilder();
		helper(val,0,s);
	
		return val;
	}

	public static void helper(List<String>ans,int idx,char []s)
	{
		
		
		System.out.println("idx "+idx);
		
		if(idx==s.length)
		{
			
			ans.add(new String(s));
			System.out.println("adding "+ans.get(ans.size()-1));
			return ;
		}
	
			
			if(Character.isAlphabetic(s[idx]))
			{
			//	without change
				System.out.println("Character at "+idx+" s "+s[idx]);
				char a=s[idx];
				s[idx]=Character.toLowerCase(a);
				helper(ans,idx+1,s);
				
				s[idx]=a;
				//sb.deleteCharAt(sb.length()-1);
				//with change
			
				
				s[idx]=Character.toUpperCase(a);
				
				helper(ans,idx+1,s);
				s[idx]=a;
				//sb.deleteCharAt(sb.length()-1);


			}else
			{
			System.out.println("Digit at "+s[idx]);
		
			helper(ans,idx+1,s);
		
			}

	}
}
