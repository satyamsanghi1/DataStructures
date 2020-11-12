package searching_and_sorting;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		int nums[]= {-1,0,3,5,9,12};
		
		search(nums,22);
	}
	 public static int search(int[] nums, int target) {
		 
		 int left=0;
		 int right=nums.length-1;
		
		 //loop break condition \
		 // when target is greater than every mid , the left pointer whill become greater than right
		 // hence the loop will be broken similarly when target is less than least value the right will become less than lef
		 
		 while(left<=right)
		 {
			
			 int mid=(left+right)/2;
			 System.out.println("left "+left+" right "+right+" mid "+ mid);
			
			 System.out.println("middle "+nums[mid]);
			 if(target==nums[mid])
			 {
				 System.out.println("found");
				 break;
			 }
			 else if(target<nums[mid])
			 {
				 //if less ,than limit the right range  to mid-1 as it is less than mid
				 right=mid-1;
				 System.out.println("less");
			 }
			 else if(target>nums[mid])
			 {
				//if greater, than limit the left  range  to mid+1 as it is greater than mid
				left=mid+1;
				 System.out.println("greater");
			 }
			
		 }
		 
		 return 0;
	 }

}
