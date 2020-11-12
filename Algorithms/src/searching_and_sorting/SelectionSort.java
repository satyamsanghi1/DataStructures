package searching_and_sorting;

public class SelectionSort {
	
	public static void main(String[] args) {
		
		
		int arr[]={30,10,50,20,60,40};
		
		for(int i=0;i<arr.length;i++)
		{
			int swap=0;
			int min=i;
			for(int k=i;k<arr.length;k++)
			{
				if(arr[k]<arr[min])
				{
					min=k;
				}
			}
			System.out.println("min index  "+min);
			//swapping 
			swap=arr[min];
			arr[min]=arr[i];
			arr[i]=swap; 
		}
		
		System.out.println("Sorted Array ");
		
		for(int i:arr)
			System.out.print(i+" ");
		
	}


}

	
