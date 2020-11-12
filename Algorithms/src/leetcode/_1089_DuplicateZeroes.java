package leetcode;

public class _1089_DuplicateZeroes {
	
	public static void main(String[] args) {
		
		int a[]= {1,0,2,3,0,4,5,0};
		//int a[]= {8,4,5,0,0,0,0,7};
		//duplicateZeros(a);
		duplicateZeroesAlter(a);
	}
	
	public static void duplicateZeroesAlter(int []a)
	{
		int x=countNoToBeDeleted(a);
		System.out.println(x);
	 	System.out.println("After shifting ");
		for(int q:a)
			System.out.print(q+" ");
		System.out.println();
	}
	
	public static int countNoToBeDeleted(int arr[])
	{
		int n=arr.length-1;
		int toBeDeleted=0;
		int count=0;
		for(int i=0;i<=n-toBeDeleted;i++)
		{
			if(arr[i]==0 )
			{
				if(i==(n-toBeDeleted))
				{
					System.out.println("here");
					arr[n]=0;
					n=n-1;
					break;
				}
				toBeDeleted++;
			}
		}
		//copying from end
		int last=n-toBeDeleted;
		System.out.println("last "+last);
		for(int i=last;i>=0;i--)
		{
			System.out.println("current "+arr[i]);
			if(arr[i]!=0) {
				System.out.println("here "+arr[i]);
			arr[i+toBeDeleted]=arr[i];
			}
			else if(arr[i]==0)
			{
				arr[i+toBeDeleted]=0;
				//i--;
			//	to	a[i+toBeDeleted]=0;
				toBeDeleted--;
				arr[i+toBeDeleted]=0;
			}
		}
		return toBeDeleted;
	}
	public static  void duplicateZeros(int[] arr) 
	{
        for(int i=0;i<arr.length;i++)
        {
        	if(arr[i]==0)
        	{
        		shift(arr,i+1);
        		arr[i+1]=0;
        		i=i+1;
            	System.out.println("After shifting ");
        		for(int q:arr)
        			System.out.print(q+" ");
        		System.out.println();
        	}
    
        }
    }
	
	public static void shift(int a[],int x)
	{
		for(int i=a.length-1;i>x;i--)
		{
			a[i]=a[i-1];
		}
		System.out.println("After shifting from "+x);
		for(int q:a)
			System.out.print(q+" ");
		System.out.println();
	}
	


}
