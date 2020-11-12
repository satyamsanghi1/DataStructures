package leetcode_alter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _47_PermutationsII {
	
	public static void main(String[] args) {
		
		String s="aabc";
			System.out.println(permuteUnique(s));
		
	}
	
	

	 public static List<String> permuteUnique(String s) {
     	List<String>permutations=new ArrayList<>();
		
		
		int [] count=new int[3];
		
		for(char c:s.toCharArray())
		count[c-'a']++;
		
		String a="";
		for(int i=0;i<count.length;i++)
		{
			if(count[i]>0)
			{
				
				a+=(char)(i+'a');
			}
		}

		StringBuilder sb=new StringBuilder();
		permute(0,a.toCharArray(), count, sb,permutations,s.length());
		System.out.println("permutations size "+permutations.size());
		return permutations;
	 }
	 
	 public static void permute(int current,char []s, int count[],StringBuilder sb,List<String>perms,int c)
	 {
		 if(sb.length()==c)
		 {
			 // add sb  to list of permutations
			 perms.add(new String(sb.toString()));
			
		 }
		 else
		 {
			 for(int i=current;i<s.length;i++)
			 {
				 
				 System.out.println("current "+i);
				 System.out.println("count of "+s[i]+" : "+count[s[i]-'a']);

					if(count[s[i]-'a']<=0)
						continue;
					
				 sb.append(s[i]);
				 traverse(count);
				 count[s[i]-'a']--;
				 System.out.println("after");
				 traverse(count);
				
			
				 System.out.println(sb.toString());
				 
				 
				 System.out.println();
				 permute(0,s, count, sb, perms, c);
				 count[sb.charAt(sb.length()-1)-'a']++;
				
				sb.deleteCharAt(sb.length()-1);
				System.out.println("after delete "+sb.toString());
				 traverse(count);
				
			 }
		 }
	 }
	

	
	  public static void traverse(int array[])
		{
			for(int i:array)
				System.out.print(i+" ");
			System.out.println();
		}
	

}
