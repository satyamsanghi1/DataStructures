import java.util.Stack;

public class Parser {
	
	public static void main(String[] args) {
		
		String s="2[a[3b]]";
		
		Stack x=new Stack();
		String p="";
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==']')
			{
				
				Character c=(char)x.pop();
				System.out.println(c);
				int q=Integer.valueOf(x.pop().toString());
				System.out.println(q);
				for(int j=0;j<q;j++)
				{
					
					p+=Character.toString(c);
				}
				System.out.println("String "+p);
				x.pop();
			}
			else if(x.size()==1)
			{
				int q=Integer.valueOf(x.pop().toString());
				for(int j=0;j<q;j++)
				{
					
				//	p+=p;
				}
			}
			else 
			{
				x.push(s.charAt(i));
				
			}
		
		}
		System.out.println(p);
		
	}

}
