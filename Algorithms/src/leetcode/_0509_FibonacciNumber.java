package leetcode;

public class _0509_FibonacciNumber {
	
	public static void main(String[] args) {
		
		//fib(6);
		
		//System.out.println(recursive(6));
		
		recursive2(6);
	}
	public static int fib(int N) {
		
		int a=0;
		int b=1;
		int sum=0;
		int q=0;
		for(int i=3;i<=N;i++)
		{	
			System.out.println(q);
		sum=a+b;
		q=sum;
		
		a=b;
		b=sum;
		}
		System.out.println("nth "+b);
		return q;
        
    }
	public static int recursive(int N)
	{
		if(N==1)
			return 0;
		else if(N==2)
			return 1;
			
		return recursive(N-1)+recursive(N-2);
	}
	public static int recursive2(int n)
	{
		//faster than previous recursing 
		//using memoization 
		int a[]=new int[n+1]; //hashtable
		
		System.out.println("ans "+memoize(n,a));
		System.out.println("traversing  ");
		traverse(a);
		System.out.println();
		System.out.println(a[n]);
		return 0;
	}
	public static int memoize(int n,int []a)
	{
		System.out.println("n "+n);
		if(n==2)
			return 1;
		if(n==1)
			return 0;
		
		if(a[n]>0)
		{
			System.out.println("in hashmap "+n);
			return a[n];
		}
		else
		{
			
			int x=memoize(n-1,a)+memoize(n-2,a);
			a[n]=x;
			System.out.println("here n"+n+" "+a[n]+"value "+x);
		}
		
		return a[n];
	}
	public static void traverse(int a[])
	{
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
	}
	

}
