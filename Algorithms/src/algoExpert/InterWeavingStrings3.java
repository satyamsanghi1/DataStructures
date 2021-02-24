package algoExpert;

public class InterWeavingStrings3 {
	//mysolution 
	//leetcode97
	
	public static void main(String[] args) {
		
//		String one="algoexpert";
//		String two="your-dream-job";
//		String three="your-algodream-expertjob";
//		
//		String one="aabcc";
//		String two="dbbca";
//		String three="aadbbcbcac";
		
		String one="aa";//this case not working in leetcode
		String two="aab";
		String three="aabaa";
		
		boolean ans=interweavingStrings(one, two, three);
		System.out.println("ans "+ans);
	}
	
	public static boolean interweavingStrings(String one, String two, String three) {
	    // Write your code here.
		Boolean [][]cache=new Boolean[one.length()+1][two.length()+1];

		 return helper(one, two, three, 0,0,cache);
	  }
	
	public static boolean helper(String one, String two, String three,int i,int j,Boolean[][]cache )
	{
	System.out.println("i "+i+" j "+j +" k "+(i+j));
		if(cache[i][j]!=null)
		{
			System.out.println("cache ");
			return  cache[i][j];
		
		}
		int k=i+j;
		
		if(k==three.length())
			return true;
		
		if(i<one.length() && one.charAt(i)==three.charAt(k))
		{
			 System.out.println("-------1---------i "+i+" j "+j +" k "+(i+j));
			cache[i][j]=helper(one, two, three, i+1, j,cache);
			System.out.println("val "+cache[i][j] +" at i "+i+" j "+j +" k "+(i+j));
			if(cache[i][j])
				return true;
		}
		 if(j<two.length() && two.charAt(j)==three.charAt(k))
		{
			 System.out.println("--------2--------i "+i+" j "+j +" k "+(i+j));
			 cache[i][j]=helper(one, two, three, i, j+1,cache);
			 System.out.println("val "+cache[i][j]+" at i "+i+" j "+j +" k "+(i+j));
			 return cache[i][j];
		}
	
		 cache[i][j]=false;
		 System.out.println("return ");
		return false;
	}
	  

}
