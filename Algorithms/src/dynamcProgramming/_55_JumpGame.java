package dynamcProgramming;

public class _55_JumpGame {
	
	public static void main(String[] args) {
		
		int nums[]= {2,3,1,1,4};
		// 2,3,1,1,4
		//1,1,1,0
		boolean ans=canJump(nums);
		System.out.println("ans "+ans);
	}
	 public static boolean canJump(int[] nums) {
		 /*We are creating the limit at each index that we can reach to 
		  * that particular index .
		  * Initially ,our limit is 3 , we can reach till index 3 ,
		  * We start our loop from index 1 : looking can we reach this index: 
		  * 	At 2: index 1: 1 <=3 we can reach this index
		  * 		also we will check if current index + nums[i] is greater than current limit
		  * 		if yes , update the new limit
		  *
		  *		At 1 :index 2 :2<=3 : pass limit not updating 
		  *		At 0:index 3 : 3<=3 : pass , limit not updating
		  *
		  *		At 4 : index4 : we cannot reach this index as limit is till index 3
		  * 
		  * 
		  */
		 
		 
		 int start=0;
		 int end=nums[0];
		 
		 for(int i=1;i<nums.length;i++)
		 {
			 System.out.println("start "+start+" end "+end);
			 
			 if(i<=end)
			 {
				 int currentLimit=(nums[i]+i);
				 System.out.println("current "+  currentLimit);
				
				 if(currentLimit>=end)
				 {
					 end=currentLimit;
				 }
				
				 
			 }
			 else
			 {
				 System.out.println("not reaching at "+i);
			 }
			 System.out.println("-------------");
			
		 }
		 
		 return true;
	 }
	
	 public static void traverse(int []jumps)
	 {
		 for(int i: jumps)
		 {
			 System.out.print(" "+i);
		 }
	 }

}
