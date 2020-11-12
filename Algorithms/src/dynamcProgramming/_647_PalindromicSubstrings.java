package dynamcProgramming;

public class _647_PalindromicSubstrings {
	
	public static void main(String[] args) {
		
		String s="abc";
		
		System.out.println("ans "+countSubstrings(s));
	}
    public static int countSubstrings(String s) {
     
    	int substrings=0;
    	
    	for(int i=0;i<s.length();i++)
    	{
    		int left=i-1;
    		int right=i+1;
    		System.out.println("at "+i);
    		substrings++;//for each character eg : in abc , a is palindrome , similarly b,c 
    		while(left>=0 && s.charAt(i)==s.charAt(left))
    		{
    			int z=((right)-(left));
    			left--;
    			System.out.println("hee "+left);
    			
    				substrings++;
    			System.out.println("z- "+z);
    		}
    		while(left>=0 && right<s.length())
    		{
    			//eg abcba
    			///when at c  we expand one is bcb , abcba hence every palindrome count
    			int z=((right)-(left));
    			if(s.charAt(left)!=s.charAt(right))
    				break;
    			
    			right++;
    			left--;
    			
    			
    				substrings++;
    			System.out.println("z "+z);
    		}
    		System.out.println("left "+left +" , right "+right);
    		
    		
    		System.out.println("-------------------");
    	}
    	return substrings;
    }
	

}
