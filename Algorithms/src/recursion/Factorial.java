package recursion;

public class Factorial {
	
	public static void main(String[] args) {
		
		
		
		int x=fibo(6);
		System.out.println(x);
		
	}
	
	public static int fibo(int n)
	{
		
		
		if( n==0)
		{
			return 0;
		}
		else if(n==1 || n==2)
		{
			return n-1;
		}
		else
		{
			
			return fibo(n-1)+fibo(n-2);
		}
		
	}
	
	
	

}
