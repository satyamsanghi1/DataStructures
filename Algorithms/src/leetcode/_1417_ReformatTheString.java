package leetcode;

import java.util.ArrayList;

public class _1417_ReformatTheString {
	
	public static void main(String[] args) {
		
		String s="ab123";
		reformat(s);
	}
	 public static String reformat(String s) 
	 {
		String alpha="";
		 int i=0;
		 for( i=0;i<s.length()-1;i++)
		 {
			 System.out.println("i "+i);
			 if(Character.isDigit(s.charAt(i)) && Character.isAlphabetic(s.charAt(i+1)))
			 {}
			 else if(Character.isDigit(s.charAt(i+1)) && Character.isAlphabetic(s.charAt(i)))
			 {}
			 else
			 {
				 System.out.println("not passed ");
				 break;
			 }
		 }
		 System.out.println("after loop "+i);
		 if(i==s.length()-1)
		 {
			 System.out.println("passed");
		 }
		 
		 ArrayList<Character>arri=new ArrayList<>();
		 ArrayList<Character>arrc=new ArrayList<>();
		 
		 for(i=0;i<s.length();i++)
		 {
			 if(Character.isDigit(s.charAt(i)))
			 {
				
				 System.out.println("character");
				 arri.add((s.charAt(i)));
			 }
			 else {
				arrc.add(s.charAt(i));
			
			 }
		 }
		
		 if(Math.abs(arri.size()-arrc.size())>1)
		 {
			 System.out.println("not");
		 }
		 else
		 {
			 int k=0;
			 int q=0;
			 
			if(arri.size()>arrc.size())
			{
				System.out.println("here");
			 while(k<arri.size() && q<arrc.size())
			 {
				 alpha+=arri.get(k);
				 alpha+=arrc.get(q);
				 
				 k++;
				 q++;
			 }
			 alpha+=arri.get(k);
			}
			else
			{
				System.out.println("in else");
			 while(k<arri.size() && q<arrc.size())
			 {
				 alpha+=arrc.get(q);
				 alpha+=arri.get(k);
				
				 
				 k++;
				 q++;
			 }
			 alpha+=arrc.get(q);
			}
			 System.out.println("alpha "+alpha);
		 }
	
		 
		 
		 System.out.println("integer list "+arri);
		 System.out.println("character list "+arrc);
		 return null;
	   }
	 

}
