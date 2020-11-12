package leetcode;

public class _189_RotateArray {
	
	public static void main(String[] args) {
		
		
		int a[]= {1,2,3,4,5,6,7};
		
		/*
		 * ALTER SOLUTION 
		 * 
		 * int q=3;
		int n=a.length-1;
		int last=0;
		int i=0;
		
		for(int k=1;k<=q;k++)
		{
		last=a[n];
		for( i=n-1;i>=0;i--)
		{
			
			a[i+1]=a[i];
			
		}
		a[++i]=last;
		System.out.println();
		traverse(a);
		}
		
		*/
		
		rotate(a,3);
		
	}
	
	public static void rotate(int nums[],int k)
	{
		///using extra array 
		
		int a[]=new int [nums.length];
		
		for(int i=0;i<nums.length;i++)
		{
			a[(i+k)%nums.length]=nums[i];
			System.out.print ((i+k)%nums.length+" ");
		}
		
		System.out.println("\n");
		traverse(a);
		
	}
	
	public static void traverse(int a[])
	{
		
		for(int x:a)
			System.out.print(x+" ");
	}

}
















