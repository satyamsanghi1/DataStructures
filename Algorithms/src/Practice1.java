import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/////PROGRAM TO FIND LONGEST SUBSTRING WITHOUT REPEATING CHARACTER 


		public class Practice1 {
			
			public static String checkPal(String s)
        	{
				System.out.println(s);
        	int count=0;
        	for(int i=0;i<s.length();i++)
        	{
        		if(s.charAt(i)==s.charAt((s.length()-1)-i))
        		{
        			count++;
        		}
        	}
        	if(count==s.length())
        	{
        	return s;
        		
        	}
        	else
        		return null;
        	}
			
         public static void main(String arg[]) 
        {
        	 String a="cbbd";
        	 int big=0;
        	 String longest="";
        	 for(int j=0;j<a.length();j++)
        	 {
        		 String x="";
        	for(int i=j;i<a.length();i++)
        	{
        		x+=a.charAt(i);
        		int num=0;
        		String z="";
        		if(checkPal(x)!=null)
        		{
        			num=checkPal(x).length();
        			z=checkPal(x);
        		}
        		
        		if(big<num)
        		{
        			big=num;
        		}
        		if(z.length()>longest.length())
        		{
        			longest=z;
        		}
        	}
        	 }
        	 System.out.println("biggest "+longest);




    

    
}
	
}
