package searching_and_sorting;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int a[]= {30,10,50,20,60,40};
		
		for(int i=0;i<a.length;i++)
		{
			//picking first element from unsorted array 
			int current=a[i];
			int j=i;
			while(j>0 && a[j-1]>current )
			{
				a[j]=a[j-1];
				a[j-1]=current;
				j--;
			}
			
		}
		System.out.println("after sorting");
		
		for(int i:a)
			System.out.print(i+" ");
	}
	

}
