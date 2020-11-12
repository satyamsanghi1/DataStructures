package leetcode;

public class _171_ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		
		int a=0;
		//65-90
		
		String s="Z";
		
		System.out.println(s.charAt(0)-'A'+1);
		
	System.out.println("Answer "+ titleToNumber(s));
		
	}
	 public static int titleToNumber(String s) {
	   // applying 10s ,100s place logic
		int x=0;
		 int y=26;
		 	for(int i=s.length()-2;i>=0;i--)
		 	{
		 		int z=(s.charAt(i)-'A'+1);
		 		System.out.println("z "+z);
		 		x+=y*z;
		 		y=y*26;
		 		 System.out.println("xx "+x);
		 	}
		 	x+=s.charAt(s.length()-1)-'A'+1;
		
		
	
		 System.out.println("x after "+x);
	 
		 return x;
	 }
}
