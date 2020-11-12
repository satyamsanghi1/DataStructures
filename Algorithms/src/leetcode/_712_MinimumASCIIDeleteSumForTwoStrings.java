package leetcode;

public class _712_MinimumASCIIDeleteSumForTwoStrings {
	
	public static void main(String[] args) {
		
		String s1="sea";
		String s2="eat";
		
		int sum=minimumDeleteSum(s1, s2);
		System.out.println("minimum sum "+sum);
	}
	 public static int minimumDeleteSum(String s1, String s2) {
		 
		 int edit[][]=new int[s1.length()+1][s2.length()+1];
		 //filling first row with ascci of s2 + prev ascii value
		 for(int i=1;i<=s2.length();i++)
		 {
			 edit[0][i]=(int)s2.charAt(i-1)+edit[0][i-1];
		 }
		 //row
		 for(int i=1;i<s1.length()+1;i++)
		 {
			 //column
			 
			 //filling asscii value of first column
			 edit[i][0]=(int)s1.charAt(i-1)+edit[i-1][0];
			
			 for(int j=1;j<s2.length()+1;j++)
			 {
				 if(s1.charAt(i-1)==s2.charAt(j-1))
				 {
					 edit[i][j]=edit[i-1][j-1];
				 }
				 else
				 {
					/* int a=edit[i-1][j];
					 int b=edit[i][j-1];
					 int toBeSubtracted=0;
					 if(a<b)
					 {
						 toBeSubtracted=(int)s1.charAt(i-1);
					 }else
					 {
						 toBeSubtracted=(int)s2.charAt(j-1);
					 }
					edit[i][j]=Math.min(a,b)+toBeSubtracted;*/
					 
					 //alter for above code
					 // top ascii value when left is char deleted
					  int top=edit[i-1][j]+(int)s1.charAt(i-1);
					  //left ascii value when top is deleted
					 int left=edit[i][j-1]+(int)s2.charAt(j-1);
					 edit[i][j]=Math.min(top,left);
				 }
			 }
			
		 }
		 for(int j=0;j<edit.length;j++)
		traverse(edit[j]);
		 return edit[s1.length()][s2.length()];
	    }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }

}
