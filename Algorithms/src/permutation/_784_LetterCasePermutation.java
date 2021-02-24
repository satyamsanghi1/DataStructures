package permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _784_LetterCasePermutation {

	//74%fast
	public static void main(String[] args) {

		String s="a1b2";

		System.out.println(letterCasePermutation(s));
	}
	public static List<String> letterCasePermutation(String S) {

		

		
		char []s=S.toCharArray();
		List<String>val=new ArrayList<>();
	        StringBuilder sb=new StringBuilder();
		helper(val,0,s,sb);
	
		return val;
	}

	public static void helper(List<String>ans,int idx,char []s,StringBuilder sb)
	{
		
		
		System.out.println("idx "+idx);
		
		if(sb.length()==s.length)
		{
			
			ans.add(new String(sb.toString()));
			System.out.println("adding "+ans.get(ans.size()-1));
			return ;
		}
	
			
			if(Character.isAlphabetic(s[idx]))
			{
			//	without change
				System.out.println("Character at "+idx+" s "+s[idx]);
				char a=s[idx];
				sb.append(Character.toLowerCase(a));
				System.out.println("------1-------"+sb.toString());
				helper(ans,idx+1,s,sb);
				
				sb.deleteCharAt(sb.length()-1);
				//with change
			
				
				sb.append(Character.toUpperCase(a));
				
				System.out.println("------2------- "+sb.toString());
				helper(ans,idx+1,s,sb);
				sb.deleteCharAt(sb.length()-1);


			}else
			{
			System.out.println("Digit at "+s[idx]);
			sb.append(s[idx]);
			System.out.println("after appending digit "+sb.toString());
			helper(ans,idx+1,s,sb);
			sb.deleteCharAt(sb.length()-1);
			}

	}
}
