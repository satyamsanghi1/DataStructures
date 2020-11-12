package leetcode;

public class _0080_RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		
		int a[]= {1,1,1,1,2,2,3,3};
		removeDuplicates(a);
	}
	 public static int removeDuplicates(int[] nums) {
		 
		 
		 int j=0; // j is slow pointer		 
		 int count=0;// keeping track of only two elemenets 
		 int element=nums[0]; // variable which is use to identify unique element 
		 // intialised with first element 
		 
		 //fast pointer 
		 
		 for(int i=0;i<nums.length;i++)
		 {
			 System.out.println("current at "+i+" , "+nums[i]);
		System.out.println("count "+count);
		//if current element is equal to elemennt than increase count and j
	//increase till count <2
			 if(nums[i]==element && count<2)
			 {
					// copy element at j // because in future it will be in use 
				 nums[j]=element;	
				 j++;	 
				 count++;
			 }
		//when 	another unique element is found
			 // update the element variable 
			 //copy at j // // as we have copied one count in increased of that variable
			 //so increase count to 1 and increase j
			  if(nums[i]!=element)
			 {
				 System.out.println("here");
				 element=nums[i];
				nums[j]=element;
				 count=1;
				 j++;
			 }
			
			 System.out.println("count "+count);
			System.out.println("j "+j);
			 traverse(nums);
			 System.out.println();
		 }
		 System.out.println("after loop j "+j);
		 //nums[--j]=nums[nums.length-1];
		 j++;
		 System.out.println("j "+j+" count "+count);
		 traverse(nums);
		
		 return 0;
	        
	    }
	 public static void traverse(int nums[])
	 {
		 for(int i:nums)
			 System.out.print(i+" ");
		 System.out.println();
	 }
}
