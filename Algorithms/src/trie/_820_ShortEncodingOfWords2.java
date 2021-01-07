package trie;

import java.util.HashSet;
import java.util.Set;



public class _820_ShortEncodingOfWords2 {
	
    
	public static void main(String[] args) {
	
		String [] words= {"time", "atime","btime"};
		
		int len=minimumLengthEncoding(words);
		System.out.println("len "+len);
	}
	public static int minimumLengthEncoding(String[] words) {
// 85%Fast 
		//algo explained at leetcode solution

		Set<String>set=new HashSet<>();

		for(String s:words)
			set.add(s);

		for(String s:words)
		{
			/*starting i with 1 because if started with 0 , will take whole word
			 * and will delete every word from the set , hence we are only looking 
			 * for suffixes
			 * 
			 */
			for(int i=1;i<s.length();i++)
			{
				if(set.contains(s.substring(i)))
				{
					set.remove(s.substring(i));
				}
			}
		}
		int ans=0;
		for(String s:set)
		{
			ans+=s.length()+1;
		}
		return ans;
	}

}
