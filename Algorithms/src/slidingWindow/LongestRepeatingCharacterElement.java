package slidingWindow;

public class LongestRepeatingCharacterElement {
	
	public static void main(String[] args) {
		
		String s="AABABBA";
		
		int k=1;
		
		characterReplacement(s, k);
	}
	public static int characterReplacement(String s, int k)
	{
        int count=0;
      
        int windowStart=0;
        int currentElement=s.charAt(0);
        int max=Integer.MIN_VALUE;
        
        for(int windowEnd=0;windowEnd<s.length();windowEnd++)
        {
        	System.out.println("cuurrent "+s.charAt(windowEnd));
        	if(s.charAt(windowEnd)!=currentElement)
        	{
        		count++;
        		//windowStart=windowEnd;
        		
        	}
        	if(count==k)
        	{
        	
        		max=Math.max(max,(windowEnd-windowStart+1));
        		System.out.println("updating max "+max);
        		count=0;
        		
        	}
        	System.out.println();
        }
     System.out.println("max "+max);
		return 0;
    }

}
