package leetcode;

public class _0038_CountAndSay {
	
	public static void main(String[] args) {
		
		
		System.out.println("answer " +cal(4,""));
	}

	public static String cal(int x,String e)
	{
		if(x==1)
		{
			return "1";
		}
	/*	if(x==2)
		{
			System.out.println("x is 2 ");
			return "11";
		}*/
		int z=x;
	
		///splitting is slower than charAt()
		
	
		String u=cal(x-1,e);
	
		System.out.println("Returned value "+u);
		System.out.println("In call "+x);
		//String s[]=Integer.toString(x).split("");
		String s[]=u.split("");
		int count=1;
		String ans="";

		int n=s.length;
		
		for(int i=0;i<u.length()-1;i++)
		{
			if(u.charAt(i)==u.charAt(i+1))
			{
				System.out.println("IF");
				count++;
		
			}
			else
			{
				System.out.println("Else");
				ans+=count;
				ans+=s[i];
				count=1;
			
			}
			
		}
		ans+=count;
		ans+=s[n-1];
		
		/*for(int i=0;i<s.length-1;i++)
		{
			System.out.println();
			System.out.println("Current "+s[i]);
			
			System.out.println("Index "+i);
			System.out.println();
			
		
			if(s[i].equals(s[i+1]))
			{
				System.out.println("IF");
				count++;
		
			}
			else
			{
				System.out.println("Else");
				ans+=count;
				ans+=s[i];
				count=1;
			
			}
			
			System.out.println("Count  " +count);
			
		}
		ans+=count;
		ans+=s[n-1];
	*/
		return ans; 
				
	}

}
