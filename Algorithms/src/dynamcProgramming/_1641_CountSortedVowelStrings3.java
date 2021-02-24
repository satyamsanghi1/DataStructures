package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _1641_CountSortedVowelStrings3 {
	 static List<Character>data=new ArrayList<>(Arrays.asList('a','e','i','o','u'));


	public static void main(String[] args) {

		int x='z';
		System.out.println(x-'a');
	
	countVowelStrings(3);
	}
	public static int countVowelStrings(int n) {

		  if(n==0)
	            return 0;
	       
	        int total=0;
			
			for(char c:data)
			{
				total+=count(n, c);
				System.out.println("--------------");
			}
			return total;
	}
	
	 public static int count(int n,char c)
		{
		 // notice that this statement is executing multiple times
			System.out.println("n "+n+" c "+c);

			if(n==1)
				return 1;
			
			int total=0;
			for(char z:data)
			{
				if(z>=c)
				{
					total+=count(n-1,z);
				}
			}
			return total;
		}
	
}
