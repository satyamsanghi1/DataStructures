package algoExpert;

public class ShiftBinarySearch {
	// in case of duplicates this algorithm will not work
	public static void main(String[] args) {
		//leetcode 33 without duplicates
		//leetcode 81 with duplicates
		int array[]= {1,3,1,1,1};
		//1,3,1,1,1  in this case it wont work
		int index=shiftedBinarySearch(array,3);
		System.out.println("ans "+index);
		
	}
	public static int shiftedBinarySearch1(int[] array, int target) {
		//recursive
		return helper(array,0,array.length-1,target);
	//	return -1;
	}
	public  static int helper(int []array,int left,int right,int target)
	{
		if(left>target)
			return -1;
		int mid=(left+right)/2;
		
		if(target==array[mid])
		{
			System.out.println("found "+mid);
			return mid;
		}
		if(array[left]<=array[mid])
		{
			if(target<array[mid] && target>=array[left])
			{
				//move left
				return helper(array,left,mid-1,target);
			}
			else
			{
				//explore right
			return 	helper(array,mid+1,right,target);
			}
		}
		else
		{
			if(target>array[mid] && target<=array[right])
			{
				//explore right
				return helper(array,mid+1,right,target);
			}
			else {
				//explore left
				return helper(array,left,mid-1,target);
			}
		}
		
	}
	 public static int shiftedBinarySearch(int[] array, int target) {
		 //iterative
		
			int left=0;
			int right=array.length-1;
			int mid=0;
			while(left<=right)
			{
				mid=(left+right)/2;
				System.out.println("left "+left+" right "+right);
				System.out.println("mid "+mid);
				if(target==array[mid])
				{
					return mid;
				}
				if(array[left]<=array[mid])
				{//left part is sorted
				
					if(target<array[mid] && target>=array[left])
					{
						//move left
						System.out.println("exploring left");
						right=mid-1;
					}
					else
					{
						//explore right
						left=mid+1;
					}
				}
				else 
				{
					//right is sorted 
					if(target>array[mid] && target<=array[right])
					{
						//explore right
						left=mid+1;
					}
					else {
						//explore left
						right=mid-1;
					}
				}
				System.out.println("left "+left+" right "+right);
				System.out.println("----------------------");
			}
		    return -1;
		    
		  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
