package leetcode;

public class _067_AddBinary {
	
	public static void main(String[] args) {
		
		//String a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
	//	String b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

		
		String a="1010";
		String b="1011";
	
		
		
	//addBinary(a, b);
	
	System.out.println("alter "+alter(a, b));
	}
	
	public static String alter(String a,String b)
	{
		StringBuilder sb=new StringBuilder();
		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;
		int sum=0;
		while(i>=0 || j>=0)
		{
			sum=carry;
			if(i>=0)
			sum+=a.charAt(i)-'0';
			if(j>=0)
			sum+=b.charAt(j)-'0';
			i--;
			j--;
			
			sb.append(sum%2);
			carry=sum/2;
			
			
		}
		if(carry>=1)
		{
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
	
	public static String addBinary(String a,String b)
	{
		int carry=0;
		String add="";
		int n=a.length()>b.length()?a.length():b.length();
		System.out.println("max length "+n);
		
		int n1=a.length()-1;
		int n2=b.length()-1;
		
		for(int i=n-1;i>=0;i--)
		{
			//System.out.println("INDEX "+i);
			int q=0;
					int w=0;
			if(n1>=0) {
			q=Integer.parseInt(a.charAt(n1)+"");
			}
			System.out.println(" q "+q);
			if(n2>=0)
			{
			 w=Integer.parseInt(b.charAt(n2)+"");
		
			}
			System.out.println(" w "+w);
			System.out.println("carry before addition "+carry);
			int c=0;
			if(w==0 && q==0 && carry==1) {
			c=w+q+carry;
			carry=0;
			}
			else
			{
				c=w+q+carry;
			}
			if(c==2) {
				carry=1;
			add+=0+"";
			}
			else if(c==1)
			{
				add+=1+"";
			}
			else if(c==0)
			{
				add+=0+"";
			}
			else if(c==3)
			{
				System.out.println("called");
				add+=1+"";
				carry=1;
			}
	
			System.out.println("add "+add);
			n1--;
			n2--;
			System.out.println("carry "+carry);
		}
		System.out.println("Outside for loop");
		System.out.println("add "+add);
		
		while(carry>0)
		{
			System.out.println("in while");
			add+=carry+"";
			carry--;
		}
		System.out.println("add "+add);
		
		return null;
	}
	
	

}
