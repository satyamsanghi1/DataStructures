package leetcode;

public class _0917_ReverseOnlyLetters {
	
	public static void main(String[] args)
	{
		
		String s="a-bC-dEf-ghIj";
		System.out.println(reverseOnlyLetters(s));
	}
		public static String reverseOnlyLetters(String S) 
		{
			char c[]=S.toCharArray();
        helper(c,0,S.length()-1);
        traverse(c);
        String q=new String(c);
        return q;
		}
		
		public static void helper(char[] s,int left,int right)
		{
			System.out.println("left ");
			if(left<right)
			{
				if(Character.isAlphabetic(s[left]) && Character.isAlphabetic(s[right]))
				{
					char swap=s[left];
					s[left]=s[right];
					s[right]=swap;
					left++;
					right--;
				}
				if(!Character.isAlphabetic(s[left]))
					left++;
				if(!Character.isAlphabetic(s[right]))
					right--;
				helper(s,left,right);
			}
		}
		public static void traverse(char c[])
		{
			for(char q:c)
				System.out.print(q+" ");
			System.out.println();
		}
		
			
}


