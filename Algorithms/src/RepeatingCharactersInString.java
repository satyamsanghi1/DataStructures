import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RepeatingCharactersInString {

	public static void main(String[] args) {
		
		String x="satyam";
		ArrayList a=new ArrayList<Character>();
		
		for(int i=0;i<x.length();i++)
		{
			a.add(x.charAt(i));
		}
		

		
		HashSet<Character> s=new LinkedHashSet<>();
		
		for(int i=0;i<a.size();i++)
		{
			
			if(s.add((Character)a.get(i))){}
			else
				{
				System.out.println("Repeating Characters "+a.get(i));
				}
			
			
		}
		
		Iterator i=s.iterator();
		
		
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

		
	}
	
}
