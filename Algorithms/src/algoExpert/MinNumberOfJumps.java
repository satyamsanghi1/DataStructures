package algoExpert;

public class MinNumberOfJumps {
	 // Youtube link : https://www.youtube.com/watch?v=5Du2iSRrbEw
	//Leetcode Jump Game II //very complicated
	public static void main(String[] args) {
		
		int []array= {2,3,1,1,4};
		
		int ans=minNumberOfJumps(array);
		System.out.println("ans "+ans);
	}
	
	 public static int minNumberOfJumps(int[] array) {
		/*in eg 3,4,2,1,2,3,7,1,1,1,3
		 * when we reach at first 1 : 
		 * 	we have exhausted our first jump : hence we increase and use
		 * 	another jump and also updates the steps remaining with that jump
		 * 
		 * Why did we set end limit to  < array.length-1
		 * in eg , 2,3,1,1,4
		 * 	 	at first 1 , we have exhausted our first jump , steps updated is 2 remain
		 * 		as max reach was index 4 ;
		 	Now when we reach at 4 the last index we have exhausted our 2nd jump :
		 		We dont want to use jump for next ,as array is ended
		 		hence we iterate loop till <length-1
		 * 
		 */
		 if(array.length==1)
			 return 0;
		 //beacuse we need atleast one jump to reach maxReach in intial case
		 // our for loop starts with index 1 not 0 
		 int jumps=1;
		 int steps=array[0];
		 int maxReach=array[0];
		 
		 for(int i=1;i<array.length;i++)
		 {
			 System.out.println("current "+array[i]);
			 maxReach=Math.max(maxReach,array[i]+i);
			 System.out.println("max Reach "+maxReach);
			 
			 steps--;
			 System.out.println("steps "+steps);
			 if(steps==0)
			 {
				 jumps++;
				 steps=maxReach-i;
			 }
			
			 System.out.println("-------------------------");
		 }
		 return jumps;
	 }
	 public static int minNumberOfJumps1(int[] array) {
		  // (O)N^2
			int [] jumps=new int [array.length];
			
			for(int i=1;i<jumps.length;i++)
				jumps[i]=Integer.MAX_VALUE;
			
			
			for(int i=1;i<array.length;i++)
			{
				System.out.println("current "+array[i]);
				for(int j=0;j<i;j++)
				{
					if(array[j]+j>=i)
					{
						jumps[i]=Math.min(jumps[i],jumps[j]+1);
					}
					traverse(jumps);
				}
				System.out.println("--------------------");
			}
		
		    return jumps[jumps.length-1];
		  }
	 public static void traverse(int []jumps)
	 {
		 System.out.println();
		 for(int i: jumps)
		 {
			 System.out.print(" "+i);
		 }
		 System.out.println();
	 }
}
