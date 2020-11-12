package searching_and_sorting;

public class FindMinimumlengthUnsortedSubarraySortingWhichMakesTheCompleteArraySorted {

	

	public static void main(String[] args) {
		
		int a[]= {10,12,20,30,25,40,32,31,35,50,60};
		
		
		int i=0;int j=0;
		//Scan from left to right and find the first element
		//which is greater than the next element.
		//Let i be the index of such an element. 
		for(int q=0;q<a.length-1;q++)
		{
			if(a[q+1]<a[q])
			{
			i=q;
			break;
			}
			
		}
		//Scan from right to left and find the first element
				//which is greateer than the next element.
				//Let j be the index of such an element. 
		for(int q=a.length-1;q>=0;q--)
		{
			if(a[q-1]>a[q])
			{
			j=q;
			break;
			}
			
		}
		
		System.out.println("i "+i+" j "+j);
		
		int min=findMin(a,i,j);
		int max=findMax(a,i, j);
		System.out.println("min "+min);
		System.out.println("max "+max);
	
	//Find the first element (if there is any) in a[0-i-1] which is greater than min,
		//change s to index of this element.
		//There is no such element in above example 1.
		
		for(int q=0;q<i;q++)
		{
			if(a[q]<min)
				i=q;
		}
		System.out.println("passed");
		//simialarly for max from backwards
		for(int q=a.length-1;q>j;q--)
		{
			if(a[q]<max)
				j=q;
		}
		// i and j are the indexs of a which sorted will make whole array sorted
		System.out.println("i "+i+" j "+j);
	}
	
	public static int findMin(int a[],int i,int j)
	{
		int min=a[i];
		for(int q=i;q<=j;q++)
		{
			if(a[q]<min)
				min=a[q];
		}
		return min;
	}
	public static int findMax(int a[],int i,int j)
	{
		int max=a[i];
		for(int q=i;q<=j;q++)
		{
			if(a[q]>max)
				max=a[q];
		}
		return max;
	}
}
