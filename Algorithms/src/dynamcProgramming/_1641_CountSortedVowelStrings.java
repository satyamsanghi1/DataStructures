package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1641_CountSortedVowelStrings {
	// very high complexity
	public static void main(String[] args) {

		
		countVowelStrings(3);
	}
	public static int countVowelStrings(int n) {

		
		List<Character>l=new ArrayList<>(Arrays.asList('a','e','i','o','u'));
		
		List<Character>data=new ArrayList<>(Arrays.asList('a','e','i','o','u'));
		
		for(int i=0;i<n-1;i++)
		{
			int size=l.size();
			System.out.println("size "+size);
			List<Character>temp=new ArrayList<>();
			
			for(int j=0;j<size;j++)
			{
				Character to=l.get(j);
				System.out.println("to "+to);
				for(Character c:data)
				{

					System.out.println(c-to);
					if(c>=to)
						temp.add(c);
					System.out.println("------------");
				}
				System.out.println("___________________");
				
			}
			System.out.println(temp.toString());
			System.out.println("temp "+temp.size());
			l=temp;
		}
		System.out.println(l.toString());
		System.out.println(l.size());
		
		return 0;
	}
}
