package LeetCode100;

public class _34_FindFirstAndLastPositionOfElementInSortedArray {
	
	
	public static void main(String[] args) {
		
		int nums[]= {5,7,7,8,8,10};
		int target=8;
		
		int x[]=searchRange(nums, target);
		System.out.println("ans "+x[0]+" , "+x[1]);
	}
	  public  static int[] searchRange(int[] nums, int target) {
		  
		  //leetcode solution
	        int[] targetRange = {-1, -1};

	        int leftIdx = extremeInsertionIndex(nums, target, true);

	        // assert that `leftIdx` is within the array bounds and that `target`
	        // is actually in `nums`.
	        if (leftIdx == nums.length || nums[leftIdx] != target) {
	            return targetRange;
	        }
	        System.out.println("left idx "+leftIdx);
	        targetRange[0] = leftIdx;
	        System.out.println();
	        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

	        return targetRange;
	    }
	  
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            System.out.println("lo "+lo +" hi "+hi+"  mid "+mid);
            if (nums[mid] > target || (left && target == nums[mid])) {
            	System.out.println("here");
                hi = mid;// increasing left if found 
            }
            else {
            	System.out.println("in else");
            	// when left=true : if not found target , then increase towards right
                lo = mid+1;
            }
        }

        return lo;
    }
    
	 public static int[] searchRange1(int[] nums, int target) {
	        
		 //my solution
		 // applying binary search to find the index
	        int left=0;
	        int right=nums.length-1;
	        int index=-1;
	           int sec_index=0;
	        int foundIndex=-1;
	        while(left<=right)
	        { 
	            int mid=(left+right)/2;

	            if(target>nums[mid])
	                left=mid+1;
	            
	            else if(nums[mid]>target)
	                right=mid-1;
	            
	            else
	            {
	                foundIndex=mid;
	                break;
	            }
	        }
	        //if not found return base case
	        if(foundIndex==-1)
	        {
	            return new int[]{-1,-1};
	        }
	        else
	        {
	        	// else expand left and right to the found index
	            int i=foundIndex;
	            while(i<nums.length && nums[i]==nums[foundIndex])
	            {
	                i++;
	            }
	              sec_index=--i;
	            i=foundIndex;
	             while(i>=0 && nums[i]==nums[foundIndex])
	            {
	                i--;
	            }
	          index=++i;
	            
	        }
	        return new int[]{index,sec_index};
	    }

}
