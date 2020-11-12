package searching_and_sorting;

public class CountingSort {
	
	public static void main(String[] args) {
		
		int arr[]= {3,6,9,8,4};
		int ans[]=new int[arr.length];
				int a[]=new int[11];
		
		for(int i=0;i<arr.length;i++)
		{
			a[arr[i]]++;
		}
	
		for(int i:a)
			System.out.print(i+" ");
		
		System.out.println();
		
		for(int i=0;i<a.length-1;i++)
		{
			a[i+1]=a[i]+a[i+1];
		}
		for(int i:a)
			System.out.print(i+" ");
		
		
		for(int i=0;i<arr.length;i++)
		{
			ans[--a[arr[i]]]=arr[i];
		}
		System.out.println();
		System.out.println("SORTED ARRAY");
		for(int i:ans)
			System.out.print(i+" ");
	}

}
