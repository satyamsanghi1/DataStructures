import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class JavaPrograms {

	public static void main (String arg[])
	{
	/*	// fibonacci series
		//  0 1 1 2 3 5 8 13 21 34
		int i,x=0,y=1,k=0;
		for(i=0;i<10;i++)
		{
			
			System.out.print(" "+x);
			k=x+y;
			y=x;
			x=k;
		}
*/
		String input;
		Scanner in=new Scanner(System.in);
		input=in.nextLine();
		Stack<Character> stk=new Stack<Character>();
		for(int i=0;i<input.length();i++)
		{
			stk.push(input.charAt(i));
		}
	ListIterator itr=stk.listIterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
		//LOGIC
	
	char[] prio= {'[','{','('};
	
	//priority [ = 0, {= 1 , ( = 2
	
	
	}
}
