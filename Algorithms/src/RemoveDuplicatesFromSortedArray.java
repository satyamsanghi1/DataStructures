
public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		
		
		int a[]= {1,2,2,3,3,4,4};
		
		//pointer that will keep track of unique elements
		int j=0;
		
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]!=a[i+1])
			{
				a[j]=a[i];
				j++;
			}
		}
		System.out.println("J "+j);
		a[j]=a[a.length-1];
		System.out.println("AFTER OPERATION");
		
		for(int i=0;i<=j;i++)
			System.out.println(a[i]);
	}

}
