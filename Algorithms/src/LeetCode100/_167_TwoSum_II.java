package LeetCode100;

public class _167_TwoSum_II {
	
	
	///use hashmap
	///calculate the complement and check in map
	public static void main(String[] args) {
		
		int numbers[]= {-3,3,4,90};
		
		int ans[]=twoSum(numbers,0);
		
		for(int i:ans)
			System.out.print(numbers[i]+" ");
	}
	
	 public static int[] bruteForce(int[] numbers, int target) {
	        
	        
	        int i=0;
	        int j=1;
	        
	        
	        for(int k=0;k<numbers.length;k++)
	        {
	        	i=k;
	        	j=i+1;
	        	System.out.println("k "+k);
	        	while(j<numbers.length && i<numbers.length-1  )
	        	{
	        		
	        		System.out.println("i "+i+" j "+j);
	            if(numbers[i]+numbers[j]==target)
	            {
	                return new int[]{i,j};        
	            }
	           j++;
	           
	        	}
	        	i=0;
	        	j=0;
	            

	            	
	        }
			 return new int[]{0,0};
	    }
	 public static int[] twoSum(int[] numbers, int target) {
		 
		
		 
		 ///using two pointers
		 //if the sum of left and right is less than target then left ++
		 //if the sum is greater than target then right--
	       int left =0;
	       int right=numbers.length-1;
	       
	       while(left<right &&left<numbers.length && right>=0)
	       {
	    	   System.out.println("right "+right);
	    	   System.out.println("left "+left);
	            int sum=numbers[left]+numbers[right];
	            System.out.println("sum "+sum);
	            if(sum==target)
	            {
	            	 return new int[]{left,right}; 	
	            }
	            if(sum>=numbers[right])
	            	right--;
	            if(sum<=numbers[left])
	            	left++;

	            	
	        }
	        
	       
	        
	        return new int[]{0,0};
		 
	 }
	 

}



















