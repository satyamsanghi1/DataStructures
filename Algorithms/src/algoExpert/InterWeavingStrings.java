package algoExpert;

public class InterWeavingStrings {
	//algoexpert
	//leetcode97
	//complexity exponential O(2^(N+M))
	public static void main(String[] args) {
		
//		String one="algoexpert";
//		String two="your-dream-job";
//		String three="your-algodream-expertjob";
//		
//		String one="aabcc";
//		String two="dbbca";
//		String three="aadbbcbcac";
		
//		String one="aacaac";//this case not working in leetcode
//		String two="aacaaeaac";
//		String three="aacaaeaaeaacaac";
		
		String one="aa";
		String two="aab";
		
		String three="aabaa";
		
		boolean ans=interweavingStrings(one, two, three);
		System.out.println("ans "+ans);
	}
	public static boolean interweavingStrings(String one, String two, String three) {
	    // Write your code here.
			
		 return helper(one, two, three, 0,0);
	  }
	
	public static boolean helper(String one, String two, String three,int i,int j )
	{
		int k=i+j;
		
		if(k==three.length())
			return true;
		
		if(i<one.length() && one.charAt(i)==three.charAt(k))
		{
			boolean a=helper(one, two, three, i+1, j);
			if(a)
				return true;
		}
		 if(j<two.length() && two.charAt(j)==three.charAt(k))
		{
			return helper(one, two, three, i, j+1);
		}
	
		return false;
	}

}
