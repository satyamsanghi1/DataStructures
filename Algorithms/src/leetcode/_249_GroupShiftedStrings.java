package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _249_GroupShiftedStrings {
	
	//leetcode locked
	/*Given an array of strings (all lowercase letters), the task is to group them in such a way that all strings in a group are shifted versions of each other. Two string S and T are called shifted if,

	S.length = T.length 
	and
	S[i] = T[i] + K for 
	1 <= i <= S.length  for a constant integer K
	
	Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};

		Output : a x
		         acd dfg wyz yab mop
		         bdfh moqs
		All shifted strings are grouped together.
*/
	
	
	public static void main(String[] args) {
		
		String[] strs= {"acd","dfg","wyz","yab","mop","bdfh","a","x","moqs"};
		
		GroupShiftedStrinngs(strs);
		
	}
	public static void GroupShiftedStrinngs(String[] strs)
	{
			/*
			 * We are finding the difference between the consecutive characters of each string
			 * the string which have same difference are grouped in that category 
			 */
		HashMap<String,List<String>>map=new HashMap<>();
		
		for(String s:strs)
		{
			StringBuilder sb=new StringBuilder();
			char c[]=s.toCharArray();
			for(int i=1;i<c.length;i++)
			{
				// size of i is less than give negative like a-y igve -24 
				// for this it should be y-a  and it should be subtracted by 26
					if(c[i]>c[i-1])
					sb.append(c[i]-c[i-1]);
					else
					{
						sb.append(26-(c[i-1]-c[i]));
					}
			}
			System.out.println("s "+sb);
			
			if(map.containsKey(sb.toString()))
			{
				List<String>l=map.get(sb.toString());
				l.add(s);
				map.put(sb.toString(),l);
			}
			else
			{
				List<String>l=new ArrayList<String>();
				l.add(s);
				map.put(sb.toString(),l);
			}
		}
		List<List<String>>ans=new ArrayList<>(map.values());
		System.out.println("ans "+ans);
	}
}
