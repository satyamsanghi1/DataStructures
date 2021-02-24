package algoExpert;

public class ThreeNumberSort {

	public static void main(String[] args) {
			//sort colors 75
		// my solution 100% Fast Using two pointers

		int []array=new int [] {2,0,2,1,1,0};
		int []order =new int [] {0,1,2};
		
		threeNumberSort(array, order);
	}
	public  static int[] threeNumberSort(int[] array, int[] order) {

		int first=order[0];
		int second=order[1];
		int i=0;
		int j=1;
		
		 i= sort(array,i,j,first);
		 traverse(array);
		 	sort(array,i,i+1,second);
		traverse(array);
		return array;

	}
	public static int sort(int []nums,int i,int j,int val)
	{
		while(j<nums.length)
		{
			if(nums[i]==val)
				i++;
			else  if(nums[j]==val)
			{
				swap(nums,i,j);
				i++;
			}
			j++;
		}
		return i;
	}
	public static void swap(int nums[],int i,int j)
	{
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	 public static void traverse(int a[])
	    {
	        for(int i:a)
	        {
	            System.out.print(i+" ");
	        }
	        System.out.println();
	    }

}
