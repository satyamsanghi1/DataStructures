package algoExpert;

public class LongestPalindromeSubString {
	
	public static void main(String[] args) {
		
	
		String str="abaxyzzyxf";
		System.out.println("answer " +longestPalindromicSubstring4(str));
	}
	 public static String longestPalindromicSubstring(String str) {
		 // algo expert solution  50%Fast beacuase we are finding odd and even palindromes
		 // in that case we are calling isPalindrome() method twice  hence taking longer time
		 
		 // 0 ,1 because substring method takes end +1 
		 // which considers single character in the input string to be palindrome by default
		 int longest[]= {0,1};
		 
		 
		 for(int i=0;i<str.length();i++)
		 {
			 /*
			  * there can be two cases : 
			  * CASE 1 : if our palindrom is aba where b is the center 
			  * 			 so we check for left and right of b ,
			  * 
			  * CASE 2 : if our length of palindrome is even , eg : abba 
			  * 			we check from the current center index 2 and its left 1
			  * 
			  */
			 int odd[]=isPalidrome(str,i-1,i+1);
			 int even[]=isPalidrome(str,i-1,i);
			 
			 System.out.println("odd "+odd[0]+", "+odd[1]);
			 System.out.println("even "+even[0]+" , "+even[1]);
			 System.out.println("-----------------------------------");
			 
			 //finding the difference between the odd substring and even substring
			 int diff[]=(odd[1]-odd[0])>(even[1]-even[0])?odd:even;
			 
			 // checking which is greatest the diff substring or the longest substring
			 longest=(longest[1]-longest[0])<(diff[1]-diff[0])?diff:longest;
		 }
		 return str.substring(longest[0],longest[1]);
	 }
	 
	 public static int[] isPalidrome(String s,int low,int high)
	 {
		 
		 while(low>=0 && high<s.length())
		 {
			 if(s.charAt(low)!=s.charAt(high))
				 break;
			 low--;
			 high++;
		 }
		 return new int[] {low+1,high};
	 }
	 public static String longestPalindromicSubstring4(String str) {
		 //(O)N^2
		 // 98% fast my solution
		 /*
		  * we use the same logic used in solution 3 
		  * but instead of strings we will store the index of  longest palindrome
		  */
		 
		 char c[]=str.toCharArray();
		 int low=0;
		 int high=0;
		 int longest_low=0;
		 int longest_high=0;
		 for(int i=0;i<c.length;i++)
		 {
			low=i-1;
			high=i+1;
			System.out.println("i "+i);
			
			 /*
			  * we have to check if left char is same to current char
			  * 
			  */
			 while(low>=0 && c[low]==c[i])
			 {
				 System.out.println("left ");
				 low--;
			 }
		while(low>=0 && high<c.length && c[high]==c[low])
			 {
				 System.out.println("left right");
				 low--;
				 high++;
				
			 }
		
				if((high)-(low)>=(longest_high-longest_low))
				{
					System.out.println("here");
					longest_high=high;// not subtracting 1 to high because sbustring method takes end value +1
					longest_low=low+1; // becauase when loop breaks low is less than a valid value
				}
			
				 System.out.println("low "+low+" high "+high);
				 System.out.println(str.substring(longest_low,longest_high));
			System.out.println("---------------------------------------");
		 }
		// System.out.println(str.substring(longest_low,longest_high));
		 return str.substring(longest_low,longest_high);
			
	 }
	 public static String longestPalindromicSubstring3(String str) {
		 
		 /*
		  * Still too slow 10%
		  * Logic : Expanding around the character 
		  * joinning and appendig of Strings taking too much time
		  * 
		  */
		 String longest="";
		 
		 char c[]=str.toCharArray();
		 int low=0;
		 int high=0;
		 int longest_low=0;
		 int longest_high=0;
		 for(int i=0;i<c.length;i++)
		 {
			 low=i-1;
			 high=i+1;
			 StringBuilder sb=new StringBuilder();
			 StringBuilder left=new StringBuilder();
			 StringBuilder right=new StringBuilder();
			 System.out.println("i "+i);
			
			 /*
			  * we have to check if left char is same to current char
			  * 
			  */
			 while(low>=0 && c[low]==c[i])
			 {
				 left.insert(0,c[low]);
				 System.out.println("left ");
				 low--;
				
			 }
			// low=center;
			
			 // check if right char is same to curent char
			 while(high<c.length && c[high]==c[i])
			 {
				 System.out.println("right");
				 right.append(c[high]); 
				 high++;
			 }
			
			 while(low>=0 && high<c.length && c[high]==c[low])
			 {
				 System.out.println("left right");
				 left.insert(0,c[low]);
				 
				 right.append(c[high]);
				 
				 low--;
				 high++;
				
			 }
			
			 left.append(c[i]);
			 left.append(right);
			 if(left.toString().length()>longest.length())
			 {
				 if(low<longest_low)
				 {
					 longest_low=low;
				 }
				 if(high>longest_high)
				 {
					 longest_high=high;
				 }
				 longest=left.toString();
			 }
			
			 System.out.println(left);
			 System.out.println("____________________");
		 }
		 System.out.println(str.substring(longest_low+1,longest_high-1));
		 return longest;
		 
	 }
	 public static String longestPalindromicSubstring2(String str) {
		   
		 // very slow solution 
		 /*
		  * (O) N^3
		  *  checking each substring is palindrome or not
		  *  creating every possible substring
		  */
		 String longest="";
		 int j=0;
		 for(int k=0;k<str.length();k++)
		 {
		 for(int i=k;i<str.length();i++)
		 {
			 String a=str.substring(k,i+1);
			 
			 System.out.println(a);
			 System.out.println(isPalindrome(a));
			 if(isPalindrome(a))
			 {
				 if(a.length()>longest.length())
				 {
					 longest=a;
				 }
			 }
			 System.out.println();
		 }
		 
		 System.out.println();
		 }
		 System.out.println("longest palindome "+longest);
		 
		 
		  return longest;
	}
	 
	 public static boolean isPalindrome(String s)
	 {
		 int i=0;
		 int j=s.length()-1;
		 
		 while(i<=j)
		 {
			 if(s.charAt(i)!=s.charAt(j))
			 {
				 return false;
			 }
			 i++;
			 j--;
		 }
		 return true;
	 }

}
