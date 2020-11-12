package searching_and_sorting;

public class Practice {
	
	public static void main(String[] args) {
		
		int a[]= {3,1,5,3,5,5,2};
		
		
		int swapCount=0;
		int swap=0;
		//bringing max to left
		
	//finding largest left 
		int max=a[0];
		int maxIndex=0;
		for(int i=0;i<a.length-1;i++)
		{
		if(max<a[i])
		{
			max=a[i];
			maxIndex=i;
			break;
		}
		
		}
		
		System.out.println("max "+max+" maxIndex "+maxIndex);
		int min=a[a.length-1];
		int minIndex=0;
		for(int i=a.length-1;i>=0;i--)
		{
		if(min>a[i])
		{
			min=a[i];
			minIndex=i;
			break;
		}
			
		}
		System.out.println("min "+min+" minIndex "+minIndex);
		
		//System.out.println("max "+max+" k "+maxIndex);

	/*	for(int i:a)
			System.out.print(i+" ");
		System.out.println("swap count "+swapCount);
		for(int i=0;i<a.length-1;i++)
		{
			int w=a[i];
			int b=a[i+1];
	
			if(w<b)
			{
				System.out.println("swapping w "+w+" b "+b );
				swap=a[i];
				a[i]=a[i+1];
				a[i+1]=swap;
				swapCount++;
			}
		}
		
		for(int i:a)
			System.out.print(i+" ");
		System.out.println("swap count "+swapCount);*/
	}

}
