
public class Question1 {
	
////Program to find the nth term in the series in which even positions are prime and odd positions are fibonacci numbers 	
	
	public static boolean calPrime(int n)
	{
		int num=1,count=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				count++;
			}
		}
		if(count==2)
		{
			return true;
		//	System.out.println("prime");
		}
		else
			return false;
			//System.out.println("not prime");
		
	}
	public static int fib(int n) 
    { 
        if (n <= 1) 
            return n; 
        return fib(n - 1) + fib(n - 2); 
    }
	
	public static void main(String[] args) {
		
	//1,2,1,3,2,5,3,7,5,11,8,13,13,17,21
		
		//odd fibo
		// even prime
		// n is the nth place in the given series
		
	int n=6;
	if(n%2==0)
	{
		System.out.println("calculating prime");
		int count=0,i=2,x;
		x=n/2;
		if(x==1)
		{
			System.out.println("prime at "+n +" is : "+1);
		}
		else {
		while(true) {
			if(calPrime(i))
			{
				count++;
			}
			if(count==x) {
				System.out.println("prime at "+n +" is : "+i);
				break;
			}
			i++;
		}
		}
		
	}
	else
	{
		n=(n+1)/2;
		System.out.println("fibo at "+n +" is: "+fib(n));
		
	}
	}
	
}
