package leetcode;

public class _053_MaximumSubArray {
	
	public static void main(String[] args) {
		
		
		int a[]= {-2,-3,4,-1,-2,1,5,-3};
		
		//int x=MaximumSumSubArray(a);
		
		int x=alterSolution(a,0,a.length-1,0);
		
		System.out.println("Maximum SubArray Sum "+x);
	}
	
	public static int alterSolution(int a[],int i,int j,int max)
	{
		if(i==j) {
			return a[j]+a[i];
		}
		
		System.out.println("i "+i +" j "+j);
		int mid=(i+j)/2;
		System.out.println("mid "+mid);
		
	System.out.println();
	
		int x=alterSolution(a,i, mid,max);
		
		System.out.println();
		
	int y=	alterSolution(a,mid+1,j,max);
		
	System.out.println( "x "+x +" y "+y);

		System.out.println();		
		if(x<0 && y<0)
			return -1;
		
		return x>y?x:y;
	}
	
	
	public static int MaximumSumSubArray(int a[])
	{
		int max=a[0];
		
		int maxSoFar=0;
		
		int start=0;
		int end=0;
		int s=0;
		
		for(int i=0;i<a.length;i++)
		{
			
			maxSoFar+=a[i];
			
			if(max<maxSoFar)
			{
				start=s;
				end=i;
				max=maxSoFar;
			}
			
	
			if(maxSoFar<0)
			{
				//this is because the addition so far has become negative 			
				maxSoFar=0;
				
				s=i+1;

			}
		}
		
		return max;
	}

}
