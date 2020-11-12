package leetcode;

public class _0283_MoveZeroes {
	
	public static void main(String[] args) {
		
		//better solution in the note book
		// copy non elemenets to the starting using two pointer
		int a[]= {4,2,4,0,0,3,0,5,1,0};
		
		//int a[]= {0,1,0,3,12};
		
		//System.out.println(3%5);
		traverse(a);
		alter(a);
		traverse(a);
	}
	
	public static void alter(int []nums)
	{
		int j=0;
		int i=0;
	
		int y=0;
		
		while(i<nums.length)
		{
			
			if(nums[i]==0)
			{			
			
				
				j=i;
				System.out.println("i "+i);
			int x=i+y;
		
			System.out.println("x "+x);
			if(x>=nums.length)
				break;
			//x++;
			while(x<nums.length)
			{
				if(nums[x]!=0)
				{
				
					System.out.println("0 position "+j);
					System.out.println("nums["+x+"] "+nums[x] );
					swap(nums,x,j);
					traverse(nums);
					break;
				}
				x++;
				
			} 
			y=x-i; ///finding difference between 0th position 
		System.out.println("y "+y);
		
			System.out.println();
			
			}
			
			i++;
		}
		
	}
	
	public static void swap(int a[],int i,int j)
	{
		int swap=0;
		swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	
	public static int count(int a[])
	{
		int count=0;
		for(int i=0;i<a.length;i++)
		{
			
			if(a[i]==0)
				count++;
		}
		return count;
	}
	
	
	public static void traverse(int a[])
	{
		
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
