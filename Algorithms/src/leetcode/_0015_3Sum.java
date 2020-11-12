package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _0015_3Sum {

	public static void main(String[] args) {
		
		int a[]= {-1,-1,0,0,2,1,1,-4};
		int target=0;
		//System.out.println(threeNumberSum(a, target));
		threeSum(a);
		
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		
		 
		 List<List<Integer>>list1=new ArrayList<>();
       //  HashSet<Integer>set=new HashSet<Integer>();
         //HashSet<Integer>set1=new HashSet<Integer>();
       
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++)
        {     	
        	if(i==0|| i>0 &&nums[i]!=nums[i-1])
        	{
        int current=i;
      
             int left=i+1;
            int right=nums.length-1;
           // if(!set1.contains(nums[current]))
           // {
            //set1.add(nums[current]);
            while( left<right)
            {
                int sum=nums[left]+nums[right]+nums[current];
                System.out.println("sum "+sum);
				System.out.println("here "+nums[current]+" ,"+nums[left]+", "+nums[right] );

                if(sum==0)
                {
                	//if(!set.contains(nums[left]) && !set.contains(nums[right])) {
                    list1.add(new ArrayList<Integer>(Arrays.asList(nums[left],nums[right],nums[current])));
                   /* set.add(nums[left]);
                    set.add(nums[right]);
                	}*/
                    while(left<right && nums[left]==nums[left+1])
                    	left++;
                    while(left<right && nums[right]==nums[right-1])
                    	right--;
                    
                   left++;
                    right--;
                  
                }
                else if(sum<0)
                left++;
                else if(sum>0)
                    right--;

            }
            //set=new HashSet();
            //set.removeAll(set);
            System.out.println();
            }
        }
        traverse(list1);
        return list1;
	
	 }
	 public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		   
		 /// when there are no duplicates in the array 
			List<Integer[]>list=new ArrayList<>();
			Arrays.sort(array);
			for(int i=0;i<array.length-2;i++)
			{
				int current=array[i];
				
				int left=i+1;
				int right=array.length-1;
				while(left<right)
				{
					//System.out.println("left "+left+" right "+right);
					int sum=array[left]+array[right]+current;
					if(sum==targetSum)
					{
						System.out.println("here"+current+" ,"+array[left]+", "+array[right] );
						list.add(new Integer[]{array[left],array[right],current});
						left++;
						right--;
						
					}
					else if(sum<targetSum)
						left++;
					else if(sum>targetSum)
						right--;
					
				}
			}
	    return list;
	  }
	 public static void traverse(List<List<Integer>>list)
	 {
		 for(List<Integer>l:list)
		 {
			// System.out.println("here");
			 System.out.println();
			 for(int i:l)
				 System.out.print(i+" ");
			 System.out.println();
		 }
	 }
}
