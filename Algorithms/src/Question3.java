import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.ListIterator;

/*
 How to remove characters from the first String which are present in the second String? (solution)
 For example, if the first String "India is great" and second String is "in" then the output should be "da s great"
  */
 

public class Question3 {

	
	static int fac=1;
	
	public static void main(String[] args) {
	
		String s1="india is great";
		
		String s2="in";
		
		s1=s1.replaceAll(" ","");
		
		System.out.println();
	
		
		for(int i=0;i<s2.length();i++)
		{
			for(int j=0;j<s1.length();j++)
			{
				
				if(s2.charAt(i)==s1.charAt(j))
				{
					System.out.println("found");
					s1=s1.replace(Character.toString(s1.charAt(j)),"");
				}
			}
			
		}
		System.out.println(s1);
		
		
			
			
			
			
		
	
	}
	
	/*public static HashSet<Character> unique(String x)
	{
	ArrayList<Character> a=new ArrayList<Character>();
		
		for(int i=0;i<x.length();i++)
		{
			a.add(x.charAt(i));
		}
		

		
		HashSet<Character> s=new LinkedHashSet<>(a);
		
		
		return s;
	}*/
	
	
	
}
