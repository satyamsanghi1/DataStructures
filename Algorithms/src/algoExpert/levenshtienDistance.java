package algoExpert;

import java.util.Arrays;

public class levenshtienDistance {
	// leetcode  72 , Edit Distance
	
	public static void main(String[] args) {
		
	String word1="b";
	String word2="";
	
	int distance=minDistanceAlter(word1, word2);
	System.out.println("min edit distance "+distance);
	}
	 public static int minDistanceAlter(String word1, String word2) {
		 //96% time-(O)NM
		 
		 //space-(O)Minimum)(N,M);
		 //because we are creating even odd array of smallest string so that they take less space
		
		String small=word1.length()<word2.length()?word1:word2;
		String big=word1.length()>=word2.length()?word1:word2;
		
		int even[]=new int [small.length()+1];
		int odd[]=new int[small.length()+1];
		
		int current[] = null;
		int previous[]=null;
		 //i row
		 for(int i=1;i<small.length()+1;i++)
		 {
			even[i]=i;
		
		 }
		 for(int i=1;i<big.length()+1;i++)
		 {
			 
			 // column
			 if(i%2==1)
			 {
				 current=odd;
				 previous=even;
			 }
			 else
			 {
				 current=even;
				 previous=odd;
			 }
			current[0]=i;
			 for(int j=1;j<small.length()+1;j++)
			 { 
				 if(j==1)
				 {
					 current[j-1]=i;
				 } 
				 if(big.charAt(i-1)==small.charAt(j-1))
				 {
					current[j]=previous[j-1];
				 }
				 else
				 {	
					 current[j]=1+(Math.min(current[j-1],Math.min(previous[j],previous[j-1])));
				 } 
				
				
			 }
			 traverse(even);
			 traverse(odd);
			

		 }
		 
		return big.length()%2==0?even[even.length-1]:odd[odd.length-1];
	 }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }
	 public static int minDistance(String word1, String word2) {
	        
		 //time-(O)N*M
		 
		 //Space (O)N*M 
		 int edit[][]=new int[word1.length()+1][word2.length()+1];
		 
		 for(int i=1;i<=word2.length();i++)
		 {
			 edit[0][i]=i;
		 }
		 for(int i=1;i<=word1.length();i++)
		 {
			 edit[i][0]=i;
		 }
		 for(int i=1;i<=word2.length();i++)
			 System.out.println(edit[0][i]);
		 
		 System.out.println();
		 for(int i=1;i<=word1.length();i++)
			 System.out.println(edit[i][0]);
		 
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
					
					 edit[i][j]=1+(Math.min(edit[i-1][j-1],Math.min(edit[i-1][j],edit[i][j-1])));
					 System.out.print(" E["+i+"]["+j+"] : "+edit[i][j]+" , ");
					 System.out.println();
				 }
			 }
			 System.out.println();
		 }
		 
		 
		 
		 return edit[word1.length()][word2.length()];
		 
	    }

}
