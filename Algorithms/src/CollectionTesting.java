import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class CollectionTesting {
	
public static boolean fun(String s,String t) {
	//String s="anagrams";
	//String t="marganaa";
//	String t="anagrams";
	boolean flag=false;
	int inc=0,i,k;
	char c[]=new char[s.length()];
	char b[]=new char[t.length()];

  System.out.println(calchar(s,c));
  System.out.println(calchar(s,b));
  int x[]=calcount(s,c);
  int y[]=calcount(t,b);
  System.out.println(x[0]);
  System.out.println(y[0]);
	
		for(i=0;i<x.length;i++)
		{
			if(x[i]==y[i])
				inc++;
		}
		System.out.println(inc);
		System.out.println(s.length());
		
		if(inc==s.length()) {
        System.out.println("Yes");
        return true;
		}
		else {
			
			System.out.println("No");
		return false;
		}
}

	public static char[] calchar(String s,char[] c)
	{
		int i,k,inc=0;
		boolean flag=false;

		for( i=0;i<s.length();i++)
		{
			for(k=0;k<s.length();k++)
			{
				if(s.charAt(i)==c[k])
					flag=true;
			}
			if(flag==false) {
			//	System.out.println("yes");
				c[inc]=s.charAt(i);
				inc++;
			}
		
			flag=false;
		}
		return c;
	}
	public static int[] calcount(String s,char c[])
	{
		int i,k;
		
		 int a[]=new int[s.length()];
		 for(k=0;k<c.length;k++)
		 {
		for(i=0;i<s.length();i++)
		{
			if(c[k]==s.charAt(i))
			{
				a[k]++;
			}
		}
		 }
		return a;
		
	}


	public static void main(String arg[])
	{
		
		String s="anagramm";
		//String t="marganaa";
		String t="marganaa";
		System.out.println(fun(s.toUpperCase(),t.toUpperCase()));
	/*	
	String s="anagrams";
	//String t="marganaa";
	String t="anagrams";
	boolean flag=false;
	int inc=0,i,k;
	char c[]=new char[s.length()];
	char b[]=new char[t.length()];

  System.out.println(calchar(s,c));
  System.out.println(calchar(s,b));
  int x[]=calcount(s,c);
  int y[]=calcount(t,b);
  System.out.println(x[0]);
  System.out.println(y[0]);
	
		for(i=0;i<x.length;i++)
		{
			if(x[i]==y[i])
				inc++;
		}
		System.out.println(inc);
		System.out.println(s.length());*/
		}
}
