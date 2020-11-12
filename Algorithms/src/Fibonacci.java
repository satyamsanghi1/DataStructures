
public class Fibonacci {

	public static void main(String[] args) {
		
		
		//// 1 1 2 3 5  8 13
		
		int n=10;
		int a=0;
		int b=1;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			
			sum=a+b;
			System.out.println(sum);
			b=a;
			a=sum;
			
		}
	
	}
}
