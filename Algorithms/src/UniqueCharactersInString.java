import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class UniqueCharactersInString {

	public static void main(String[] args) {
		
		String x="satyam";
		ArrayList a=new ArrayList<Character>();
		
		for(int i=0;i<x.length();i++)
		{
			a.add(x.charAt(i));
		}
		

		
		HashSet s=new LinkedHashSet<>(a);
		
		Iterator i=s.iterator();
		
		
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

	}

}
