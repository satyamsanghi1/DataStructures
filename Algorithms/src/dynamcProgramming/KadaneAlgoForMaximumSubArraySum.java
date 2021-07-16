package dynamcProgramming;

public class KadaneAlgoForMaximumSubArraySum {
	
	public static void main(String[] args) {
		
		int a[]= {-2,1,-3,4,-1,2,1,-5,4};
		
		kadane(a);
		//int a[]= {-2,-3,4,-1,-2,1,5,-3};
		
		//int a[]= {3,-2,5,-1};
		//int x=MaximumSumSubArray(a);
		
		//int x=alterSolution(a,0,a.length-1,0);
		//bruteForce(a);
		//dSystem.out.println("Maximum SubArray Sum "+x);
	}
	
	public static void kadane(int a[])
	{
		//revision coding
		int max=Integer.MIN_VALUE;
		int currentSum=0;
		
		int start=0;
		int end=0;
		int curStart=0;
		
		for(int i=0;i<a.length;i++)
		{
			currentSum+=a[i];
			
			if(currentSum>max)
			{
				max=currentSum;
				start=curStart;
				end=i;
			}
			if(currentSum<0)
			{
				curStart=i+1;
				currentSum=0;
			}
		}
		System.out.println("start "+start+" end "+end +" maxsum "+max);
	}
	public static void bruteForce(int a[])
	{
		int max=a[0];
		int min=0;
		for(int i=0;i<a.length;i++)//tells pair length 
		{
			System.out.print("[ ");
			for(int j=0;j<a.length-i;j++)
			{
				System.out.print(" (");
				for(int k=j;k<=i+j;k++)
				{
					System.out.print(a[k]+",");
					min+=a[k];
				}
				if(max<min) {
				max=min;
				}
				min=0;
				System.out.print(") ");
			
			}
		
			System.out.print(" ]");
			System.out.println();
		}
		
		System.out.println("max "+max);
		
	}
	
	
	public static int DivideAndConquer(int a[],int i,int j,int max)
	{
		
		//this is not working
		if(i==j) {
			return a[i];
		}
		
		int x=0;
		int y=0;
		
		
		
		int mid=(i+j)/2;
		
		
	System.out.println();
	
		 x=DivideAndConquer(a,i, mid,max);
		
		System.out.println();
		
	 y=	DivideAndConquer(a,mid+1,j,max);
	 System.out.println("mid "+mid);
	 System.out.println("i "+i +" j "+j);
	
		System.out.println();		
		
		int leftSum=0;
		int rightSum=0;
		int sum=0; //for whole subarray i.e. leftsubarray + rightsubarray
		//left subarray
		
		for(int q=i;q<=mid;q++)
		{
			sum+=a[q];
			leftSum=sum>leftSum?sum:leftSum;
		}
		//right subarray
		for(int q=mid+1;q<=j;q++)
		{
			sum+=a[q];
			rightSum=sum>rightSum?sum:rightSum;
		}
		
		
		System.out.println();
		System.out.println("left Sum "+leftSum +" rightSum "+rightSum);
	
		
		int ans= x>y?x:y;
		
		return ans>(leftSum+rightSum)?ans:(leftSum+rightSum);
		
		
	}
	
	
	public static int MaximumSumSubArray(int a[])
	{
		
		//kadane algorithm 
		
		
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
		System.out.println("start "+start);
		System.out.println("end "+end);
		
		return max;
	}

}
