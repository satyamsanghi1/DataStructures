package recursion;

public class StringReverse {
	
	public static void main(String[] args) {
		
		String x="abc";
		
		char[] c=x.toCharArray();
		
		reverse(c,0,x.length()-1);
		System.out.println(c);
	}
	
	public static void reverse(char[] c,int l,int h)
	{
		if(l<h) {
		swap(c,l,h);
		reverse(c,l+1,h-1);
		
		}
	}
	
	public static void swap(char []c,int l,int h)
	{
		char swap=c[l];
		c[l]=c[h];
		c[h]=swap;
		
	}

}
