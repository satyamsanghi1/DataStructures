package searching_and_sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		
		
		int arr[]= {9,4,6,3,7,1,2,11,5};
		
		
		/*int pivot=arr[arr.length-1];
		int j=0;
		int i=j-1;
		int swap=0;
		while(j<arr.length)
		{
			if(arr[j]<=pivot)
			{
				i++;
			//swapping elements at i and j
				swap=arr[i];
				arr[i]=arr[j];
				arr[j]=swap;
			}
			j++;
			
		}
		
		System.out.println("After finding pivot ");
		
		for(int q:arr)
			System.out.print(q+" ");*/
		//quickSort(arr,0,arr.length-1);
		divide(arr,0,arr.length-1);
		
	}
	
	public static void divide(int a[],int i,int j)
	{
		System.out.println("("+i+","+j+")");
		int r=quickSort(a,i,j);
		System.out.println("position of pivot "+r);
		
		
		if(i<j) {
		divide(a,i,r-1);
		divide(a,r+1,j);
		}
		//quickSort(a,i,mid-1);
		//quickSort(a,mid+1,j);
		
	}
	
	public static int quickSort(int arr[],int a,int b)
	{
		int pivot=arr[b];
		int j=a;
		int i=j-1;
		int swap=0;
		//System.out.println("pivot "++);
		while(j<arr.length)
		{
			if(arr[j]<=pivot)
			{
				i++;
			//swapping elements at i and j
				swap=arr[i];
				arr[i]=arr[j];
				arr[j]=swap;
			}
			j++;
			
		}
		System.out.println("i "+i);
		System.out.println("After finding pivot ");
		
		for(int q:arr)
			System.out.print(q+" ");
		System.out.println();
		return i;
	}

}
