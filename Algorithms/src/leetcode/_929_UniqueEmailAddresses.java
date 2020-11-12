package leetcode;

import java.util.HashSet;

public class _929_UniqueEmailAddresses {
	
	public static void main(String[] args) {
			
		
	String emails[]= {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
	System.out.println("answer "+numUniqueEmails(emails));
	
	}
	 public static  int numUniqueEmails(String[] emails) {
		 //best solution 
		 HashSet<String>set=new HashSet<>();
		 
		 String email=emails[0];
		 
		 email=email.replaceAll("\\.","");
		 System.out.println("email : "+email);
		 return set.size();
	 }
	  public static  int numUniqueEmailsAlter(String[] emails) {
		  // my solution 
		  HashSet<String>set=new HashSet<>();
		for(String email:emails)
		{
			
			StringBuilder sb=new StringBuilder();
			String [] a=email.split("@");
			for(char c:a[0].toCharArray())
			{
				if(c!='+')
				{
				if(c!='.')
				{
					sb.append(c);
				}
				}else
				{
					break;
				}
				
			}
			sb.append("@");
			sb.append(a[1]);
			set.add(sb.toString());
			System.out.println(sb.toString());
			sb=null;
		} 
			return set.size();
	    }

}
