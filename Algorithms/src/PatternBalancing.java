import java.util.Stack;

public class PatternBalancing {
public static void main(String[] args) {
	
	
	String a="[()[[]()]]";
	boolean flag=true;
	Stack<Character>k=new Stack<Character>();
	
	for(int i=0;i<a.length();i++)
	{
		System.out.println("Element is "+a.charAt(i));
		if(k.isEmpty() && a.charAt(i)=='(')
		{
			System.out.println("calling1 ");
			k.push(a.charAt(i));
		}
		else if(k.isEmpty() && a.charAt(i)=='{')
		{
			System.out.println("calling7 ");
			k.push(a.charAt(i));
		}
		else if(k.isEmpty() && a.charAt(i)=='[')
		{
			System.out.println("calling8 ");
			k.push(a.charAt(i));
		}
		else if(k.isEmpty() &&a.charAt(i)==']')
		{
			flag=false;
			System.out.println("cout "+false);
			break;
		}
		else if(k.isEmpty() &&a.charAt(i)==')')
		{
			flag=false;
			System.out.println("cout "+false);
			break;
		}
		else if(k.isEmpty() &&a.charAt(i)=='}')
		{
			flag=false;
			System.out.println("cout "+false);
			break;
		}
		else if(k.peek()=='(' && a.charAt(i)=='}')
		{
			flag=false;
			System.out.println("cout "+false);
			break;
		}
		else if(k.peek()=='(' && a.charAt(i)==']')
		{
			flag=false;
			System.out.println("cout "+false);
			break;
		}
		else if(k.peek()=='{' && a.charAt(i)==']')
		{
			System.out.println("cout "+false);
			break;
		}
		else if(k.peek()=='{' && a.charAt(i)=='{')
		{
			System.out.println("calling4");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='[' && a.charAt(i)=='(')
		{
			System.out.println("calling12");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='[' && a.charAt(i)=='[')
		{
			System.out.println("calling13");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='(' && a.charAt(i)=='[')
		{
			System.out.println("calling11");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='(' && a.charAt(i)=='{')
		{
			System.out.println("calling6");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='{' && a.charAt(i)=='[')
		{
			System.out.println("calling10");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='{' && a.charAt(i)=='}')
		{
			System.out.println("calling5");
			k.pop();
		}
		else if(k.peek()=='[' && a.charAt(i)==']')
		{
			System.out.println("calling9");
			k.pop();
		}
		else if(k.peek()=='(' && a.charAt(i)=='(')
		{
			System.out.println("calling2");
			k.push(a.charAt(i));
		}
		else if(k.peek()=='(' && a.charAt(i)==')')
		{
			System.out.println("calling3");
			k.pop();
		}
		
	}
	if(k.isEmpty() && flag==true)
	{
		System.out.println(true);
	}
	else if(flag==false)
	{
		System.out.println(false);
	}
			
		
	
	
}
}
