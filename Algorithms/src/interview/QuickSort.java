package interview;

public class QuickSort {
	static int x=0;
	
	public static void main(String[] args) {
		
		
		int arr[]=new int [] {5,1,1,2,0,0};
		
		quickSort(arr,0,arr.length-1);
		
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int arr[],int i,int j)
	{
		System.out.println("i "+i+" j "+j);
		if(j<=i)
			return ;
		
		int pivot=arr[i];
		
		int left=i+1;
		int right=j;
		
		
		while(left<=right)
		{
		
			System.out.println("left "+arr[left]+" right "+arr[right]);
			if(arr[left]>pivot && arr[right]<pivot)
			{
				swap(arr,left,right);
				left++;
				right--;
			}
			 if(arr[left]<=pivot)
				left++;
			 if(arr[right]>=pivot)
				right--;
			
		}
		
		swap(arr,i,right);
		System.out.println("---------");
		System.out.println("left "+left+" right "+right);
		traverse(arr);
		System.out.println("____________________________");
		
		//for saving space on call stack
		// smaller one will finish earlier
		boolean leftArrayIsSmaller=(right-1-i)<(j-(right+1));
		if(leftArrayIsSmaller) {
		quickSort(arr, i,right-1);
		quickSort(arr, right+1, j);
		}
		else
		{
			quickSort(arr, right+1, j);
			quickSort(arr, i,right-1);
		}
	}
	
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void traverse(int arr[])
	{
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
