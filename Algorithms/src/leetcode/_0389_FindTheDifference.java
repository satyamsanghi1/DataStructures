package leetcode;

public class _0389_FindTheDifference {
	
	public static void main(String[] args) {

		String s="a";
		String t="aae";
				
			findTheDifference(s, t);
	}
	public static char findTheDifference(String s, String t) 
	{

		int ch[]=new int[26];
		
		for(char c:s.toCharArray())
		{
			ch[c-97]++;
			
			
		}
		
		for(char c:t.toCharArray())
		{
			ch[c-97]--;
		
		}
		System.out.println();
		for(int q:ch)
			System.out.print(q+" ");
		System.out.println();
		char c = 0;
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]>1)
			{
				ch[i]--;
			}
			else if(ch[i]==1 || ch[i]==-1) {
				 c=(char) (i+97);
				System.out.println(c);
			}
		}
		
		return c;
		
	}

}
