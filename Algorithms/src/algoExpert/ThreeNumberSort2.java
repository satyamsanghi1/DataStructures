package algoExpert;

public class ThreeNumberSort2 {

	public static void main(String[] args) {
			//sort colors 75
		//  100% Fast Using two pointers

		int []array=new int [] {7, 8, 9, 7, 8, 9, 9, 9, 9, 9, 9, 9};
		int []order =new int [] {8,7,9};
		
		threeNumberSort(array, order);
	}
	public  static int[] threeNumberSort(int[] array, int[] order) {

		
		int first=0;
		int second=0;
		int third=array.length-1;
		
		while(second<=third)
		{
			System.out.println("first "+first+" second "+second+" third "+third);
			if(array[second]==order[0])
			{
				swap(array,first,second);
				first++;
				second++;
			}
			else if(array[second]==order[1])
			{
				second++;
			}
			else
			{
				/*not increasing second because we dont know what is coming 
				 * from third index which we swapped it could be 0 hence we have to 
				 * recheck it to first , if we had moved second , we would have missed 
				 * this 0
				 */
				swap(array,third,second);
				third--;
			}
			
			
		
			traverse(array);
			System.out.println("-----------");
		}
		
		
		return array;

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
