package dynamcProgramming;

public class _583_DeleteOperationForTwoStrings {
	public static void main(String[] args) {

		String word1="sea";
		String word2="eat";
		
		int x=minDistance(word1, word2);
		System.out.println("min "+x);
	}

	public static int minDistance(String word1, String word2) {

		int edit[][] = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 1; i <= word2.length(); i++) {
			edit[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			edit[i][0] = i;
		}

		
		 for(int i=1;i<=word1.length();i++)
		 {
			 for(int j=1;j<=word2.length();j++)
			 {
				 System.out.print(word1.charAt(i-1)+", "+word2.charAt(j-1));
				 int x=edit[i-1][j-1];
				 int q=edit[i-1][j];
				 int z=edit[i][j-1];
				 System.out.println(" : x "+x+" y "+q+" z "+z);
				 if(word1.charAt(i-1)==word2.charAt(j-1))
				 {
					 edit[i][j]=edit[i-1][j-1];
					 System.out.println("E["+i+"]["+j+"] : "+edit[i][j]+" , ");
				 }
				 else
				 {	
					// we cannot replace words only delete
					 edit[i][j]=1+Math.min(edit[i-1][j],edit[i][j-1]);
					 System.out.print(" E["+i+"]["+j+"] : "+edit[i][j]+" , ");
					 System.out.println();
				 }
			 }
			 System.out.println();
		 }
		return edit[word1.length()][word2.length()];
	}

}
