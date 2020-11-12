import java.util.ArrayList;
import java.util.ListIterator;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		
		int [] a= {100, 4, 200, 1, 3, 2,5,7,101,102,103,201,202,203,205,206,204};
		ArrayList s=new ArrayList();
		
		for(int x:a)
		{
			s.add(x);
		}
		
		TreeSet<Integer>t=new TreeSet<>(s);
		ArrayList ar=new ArrayList(t);
		ListIterator i=ar.listIterator();
		ListIterator it=ar.listIterator();
		
		int val=t.first();
		int count=0;
		int max=0;
		System.out.println("first value"+ val);
		
		
		while(i.hasNext())
		{
			System.out.print(i.next()+" , ");
		}
		System.out.println();
		while(it.hasNext())
		{
			
			if(val==(int)it.next())
			{
				
				count++;
				max=count;
				val++;
				System.out.println("count "+count+" value "+val);
			
			}
			else
			{
				val=(int) it.previous();
				System.out.println("enterv "+val);
				count=0;
			}
			
		}
		System.out.println("\ncount value "+max);
		
	}

}
