
import java.util.Scanner;

public class StringPro 
{
	static void checkString(String s,int n)
	{
		int i,j=0,k,count=0,index = 0,val=0;
		//for(k=index;k<s.length();k++
	//	{
		char c;
		index=val;
		
		
		for(k=0;k<n;k++) {
			c=s.charAt(index);
			System.out.print(s.charAt(index));
		for(i=index;i<s.length();i++)
		{
			
			if(s.charAt(i)==c)
			{
				count++;
			}
			else
			{
				index=i;
				break;
			}
	}
		
		//System.out.print(index+" ");
		val=index;
		System.out.print(count);
		count=0;
		
		}
		
	}
	static int findDistinct(String s)
	{
	    String a="";
	    boolean flag=false;
	    for(int i=0;i<s.length();i++)
	    {
	    	char c=s.charAt(i);
	    	for(int k=0;k<a.length();k++)
	    	{
	    		if(c==a.charAt(k))
	    		{
	    			flag=true;
	    		}
	    	}
	    	if(flag!=true)
	    	{
	    		a=a+c;
	    	}
	    	flag=false;
	    }
	    return a.length();
	    //StringBuilder str=new StringBuilder(a);
	    //System.out.println(a);
	   //System.out.println(str.reverse());
	}
	
public static void main(String arg[])
{
	Scanner in=new Scanner(System.in);
	String a=in.next();
	
	String s="wwwwaaabbbccddd";
  //System.out.println(findDistinct(s));
	findDistinct(a);
	checkString(a,findDistinct(a));
	
}
}
