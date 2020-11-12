package leetcode;

public class _0013_RomanToInteger {
	
	public static void main(String[] args) {
		
		String s="D";
		int count=0;

		if(s.length()==1)
		{
			count= cal(s.charAt(0));
			System.out.println("count "+count);
		}else {
		 for(int i=0;i<s.length()-1;i++)
		 {
			 System.out.println("CURRENT VALUE "+s.charAt(i));
			 
			 int a=cal(s.charAt(i));
			 System.out.println("a "+a);
			 int b=cal(s.charAt(i+1));
			 System.out.println("b "+b);
			 
			 if(a<b)
			 {
				 System.out.println("a-b "+(a-b));
				 System.out.println("called");
				 int x=(a-b);
				 x=-x;
				 count+=x;
			 i++;
		
				 System.out.println("count value "+count);
			 }
			 else
			 {
				 System.out.println("else");
				 count+=cal(s.charAt(i));
				 System.out.println("count value "+count);

			 }

		 }
		
		 if(cal(s.charAt(s.length()-2))  >=  (cal(s.charAt(s.length()-1))))
		 count+=cal(s.charAt(s.length()-1));
		 System.out.println("count "+count);
		}
		
	}
	
	public static int cal(char c)
	{
		
		switch(c)
		{
		case 'I':
		{
			return 1;
			
		}
		case 'V':
		{
			return 5;
	
		}	
		case 'X':
		{
			return 10;

		}	
		case 'L':
		{
			return 50;

		}	
		case 'C':
		{
			return 100;
		
		}	
		case 'D':
		{
			return 500;
			
		}
		case 'M':
		{
			return 1000;
		
		}

	}
		return c;

}
}