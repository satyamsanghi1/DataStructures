package algoExpert;

public class InterWeavingStrings2 {
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
		
		String one="aacaac";//this case not working in leetcode
		String two="aacaaeaac";
		String three="aacaaeaaeaacaac";
		
		boolean ans=interweavingStrings(one, two, three,0,0,0);
		System.out.println("ans "+ans);
	}
	public static boolean interweavingStrings(String one, String two, String three,int i,int j,int k) {
	    // Write your code here.
			
		 if((one.length()+two.length())!=three.length())
	            return false;
		 
			while(i<one.length() && j<two.length() && k<three.length())
			{
				System.out.println("i "+i+" j "+j+ " k "+k);
				char a=one.charAt(i);
				char b=two.charAt(j);
				char c=three.charAt(k);
				System.out.println(a+" , "+b+" ,"+c);
				
				if(a==b)
				{
					System.out.println("here at ");
				return	interweavingStrings(one, two, three,i+1,j,k+1) ||
					interweavingStrings(one, two, three,i,j+1,k+1);
				}
				if(c==a)
				{
					i++;
				}
				else if(c==b)
				{
					j++;
				}
				else
				{
					System.out.println("return false");
					return false;
				}
				k++;
				System.out.println("----------------");
			}
		
			System.out.println("end i "+i+" j "+j+ " k "+k);
			System.out.println("one "+one.substring(i,one.length()));
			System.out.println("two "+two.substring(j,two.length()));
			System.out.println("three " +three.substring(k,three.length()));
			
			
			
			if(i>=0 &&i<one.length() && one.substring(i,one.length()).equals(three.substring(k,three.length())))
			{
				System.out.println("in i");
				return true;
			}
			 if(j>=0 && j<two.length() && two.substring(j,two.length()).equals(three.substring(k,three.length())))
			{
				 System.out.println("in j");
				return true;
			}
			System.out.println("end ");
	    return k==three.length();
	
	  }

}
