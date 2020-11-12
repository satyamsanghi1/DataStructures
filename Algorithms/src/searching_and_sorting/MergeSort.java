package searching_and_sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		
		int arr[]= {5,4,3,2,1};
		
		
		sort(arr,0,arr.length-1);
		System.out.println("AFTER SORTING");
		
		for(int i:arr)
		{
			System.out.println(i);
		}
	}
	
	public static void sort(int arr[],int l,int h)
	{
		if(l==h) {
			System.out.println("value "+arr[l]);
		//	return ;
		}else {
		System.out.println("L "+l+" H "+h);

		
		int mid=(l+h)/2;
		
		//System.out.println("middle value " +mid);
		
		sort(arr,l,mid);
		sort(arr,mid+1,h);
		
		merge(arr,mid,l,h);
		System.out.println();
		//System.out.println("a "+a);
		//System.out.println("b "+b);
		}
	
		
	}
	
	public static void merge(int []arr,int m,int l,int r)
	{
		System.out.println("In MERGE L "+l+" R "+r+" Middle "+m);
		// finding the size of two subarrays to be merged
		
		int n1=m-l+1;
		System.out.println("HEIGHT OF FIRST SUB ARRAY "+n1);
		
		int n2=r-m;
		System.out.println("HEIGHT OF SECOND SUB ARRAY "+n2);
		System.out.println("MIDDLE "+m);
		
		int a[]=new int[n1];
		int b[]=new int[n2];
		
		for(int i=0;i<n1;i++)
		{
			a[i]=arr[i+l];
		}
		System.out.println("Traversing array A");
		for(int q:a)
			System.out.print(q+" , ");
		System.out.println();
		
	
		for(int i=0;i<n2;i++)
		{
			b[i]=arr[i+m+1];
		}
		System.out.println("Traversing array B");
		for(int q:b)
			System.out.print(q+" , ");
		
		System.out.println();
		//comparing both the arrays 
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i<n1 &&  j<n2)
		{
			if(a[i]<b[j])
			{
				arr[k]=a[i];
				i++;
			}
			else
			{
				arr[k]=b[j];
				j++;
			}
			k++;
		}
		System.out.println("I "+i);
		System.out.println("J "+j);
		while(i<n1)
		{
			arr[k]=a[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			arr[k]=a[j];
			j++;
			k++;
		}
		
		System.out.println("TRAVERSING ARAY ");
		
		for(int w:arr)
		{
			System.out.print(w+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
