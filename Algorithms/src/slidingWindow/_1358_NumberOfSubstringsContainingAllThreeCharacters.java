package slidingWindow;

public class _1358_NumberOfSubstringsContainingAllThreeCharacters {
	
	public static void main(String[] args) {
		
		String s="aabca";
		
		numberOfSubstrings1(s);
	}
	 public static 	int numberOfSubstrings1(String s) {
		 
		 /*
		  * We are using sliding window technique to solve this problem 
		  * 
		  *  Step 1 :  if all the characters (a,b,c) are present in the current window : 
		  * 			-> it means that all the substrings substring(start, end), 
		  * 				substring(start, end + 1), …, substring(start, n) are valid substrings.  
		  * 
		  * 
		  * example : abcabc : at index 2 , we have all the chars : 
		  * 					hence , all the substrings like , abca,abcab,abcabc are also valid substrings ,
		  * 			Therefore we add , unique+=lengthOfString(6)-index(2)=4
		  * 			
		  * -> after this, we start shrinking our window , i .e. start deleting chars from starting index ; windowStart
		  *  if the window still contains all the chars , we count in substrings (start,end),(start,end+1),(start,n);
		  * 			as soon as , any of char (a,b,c) is less than 1 , we again start expanding our window
		  * 			(this step can be seen in eg : (aabca)
		  * 	
		  * 
		  * Step 2 : if not all chars are present, we move end to the right and calculate the
		  * 			no of characters at each index until all the chars are found
		  * 
		  * 
		  * 
		  */
		 
		 int substrings=0;
		 
		 char c[]=s.toCharArray();
		 int bank[]=new int[3];
		
		 int windowStart=0;
		 
		 for(int windowEnd=0;windowEnd<c.length;windowEnd++)
		 {
			 bank[c[windowEnd]-'a']++;
			 
			 while(bank[0]>0 && bank[1]>0 && bank[2]>0)
			 {
				 
				 substrings+=c.length-windowEnd;
				 
				 bank[c[windowStart]-'a']--;
				 windowStart++;
			 }
		 }
		 System.out.println("substrings "+substrings);
		 
		 return substrings;
	 }
	 public static 	int numberOfSubstrings(String s) {
		
		 // very slow // TIME LIMIT EXCEEDED
		 /*
		  * In this solution as soon as we are getting all the occurance of a,b,c at the index end
		  * we are counting the no of substrings from starting to the index  till this index end.
		  * 
		  * 
		  */
		 int substrings=0;
		 
		 char c[]=s.toCharArray();
		 int bank[]=new int[3];
		 int unique=0;
		 for(int windowEnd=0;windowEnd<c.length;windowEnd++)
		 {
			 bank[c[windowEnd]-'a']++;
			 
			 if(bank[c[windowEnd]-'a']==1)
				 unique++;
			 
			 if(unique>=3)
			 {
				 int alter[]=bank.clone();
				 int count=unique;
				 int i=0;
				 while(count>=3)
				 {	
					 System.out.println("at index "+windowEnd);
					 alter[c[i]-'a']--;
					 if(alter[c[i]-'a']==0)
					 {
						 count--;
					 }
					
					 i++;
					 if(count>=3)
					 {
						 System.out.println("inc");
					 substrings++;
					 }
				 }
				 substrings++;
			 }
		 }
		 System.out.println("substrings "+substrings);
		 return substrings;
	 }
	 public static 	int numberOfSubstringsAlter(String s) {
	        
		 // very high complexity 
		 // giving time limit exceeded error
		 int substrings=0;
		 char c[]=s.toCharArray();
		
		 for(int i=0;i<c.length;i++)
		 {
			 
			 int bank[]=new int[3];
			 int count=0;
			 int unique=0;
			 for(int k=i;k<c.length;k++)
			 {
				 bank[c[k]-'a']++;
				 if(bank[c[k]-'a']==1)
				 {
					 unique++;
				 }
				 
			 		
					 count++;
					 if(unique==3)
					 {
						 substrings++;
					 System.out.println("inc");
					 }
				 
				
				 traverse(bank);
			 }
			 System.out.println();
			 
		 }
		 
		 System.out.println("substrings "+substrings);
		
		 return substrings;
	    }
	 public static boolean check(char c)
	 {
		 if(c=='a' || c=='b' || c=='c')
			 return true;
		 return false;
	 }
	 public static void traverse(int array[])
		{
			for(int i:array)
				System.out.print(i+" ");
			System.out.println();
		}

}
