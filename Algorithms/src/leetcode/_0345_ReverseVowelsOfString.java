package leetcode;

public class _0345_ReverseVowelsOfString {

	public static void main(String[] args) {
		
		String s="\"Slang is not suet, is it?\" Euston signals.";
		
		System.out.println(s.charAt(0));
		System.out.println(reverseVowels(s));
	}
	
	 public static String reverseVowels(String s) {

		 int left=0;
		 int right=s.length()-1;

		 char a[]=s.toCharArray();
		 while(left<right)
		 {
			 System.out.println("left "+a[left]+" right "+a[right]);
			 
			 if(!checkVowel(a[left]) && !checkVowel(a[right]))
			 {
				 left++;
				 right--;
			 }
			 else  if(!checkVowel(a[left]))
			 {   
				 left++;
			 }
			 else if(!checkVowel(a[right]))
			 {
				 right--;
			 } 
			 else if(checkVowel(a[left]) && checkVowel(a[right]))
			 {   
				 char swap;
				
				 swap=a[left];
				 a[left]=a[right];
				a[right]=swap;
				 left++;
				 right--;
			 }
		              

	           }
	     	return new String(a);
	    }
	 
	 public static boolean checkVowel(char c)
	    {
	        if(c=='a' || c=='e'  || c=='i'  || c=='o'  || c=='u')
	            return true;
	        
	        if(c=='A' || c=='E'  || c=='I'  || c=='O'  || c=='U')
	        	return true;
	        
	        return false;
	    }
}
