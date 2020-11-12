package algoExpert;

public class SubarraySort {

	public static void main(String[] args) {
		
	//int array[]= {1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19};
	//int array[]= {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
	int array[]= {2,6,4,8,10,9,15};
	//int array[]= {2,1};
	//int array[]= {1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19};
	subarraySort(array);
		
	}
	
	
	  public static int[] subarraySort(int[] array) {
		    // Write your code here.
		  
		int low=Integer.MAX_VALUE;
		int high=Integer.MIN_VALUE;
		  
		  for(int i=0;i<array.length;i++)
		  {
			  
			  if(outOfOrder(array[i], i, array))
			  {
				  low=Math.min(low,array[i]);
				  high=Math.max(high,array[i]);
			  }
		  }
		  
		  if(low==Integer.MAX_VALUE)
			  return new int [] {-1 ,-1};
		  System.out.println("low "+low);
		  System.out.println("high "+high);
		  int lowIdx=0;
		  int highIdx=array.length-1;
		  while(array[lowIdx]<=low)
		  {
			  lowIdx++;
		  }
		  
		  while(array[highIdx]>=high)
			  highIdx--;
		System.out.println("low Idx "+lowIdx);
		System.out.println("high Idx "+highIdx);
		 
		    return new int[] {lowIdx,highIdx};
		  }
	  public static boolean outOfOrder(int num,int i,int []array)
	  {
		  if(i==0)
		  return array[i+1]<array[i];
		  
		  else if (i==array.length-1)
			 return array[i-1]>array[i];
			 
			 else
				 return array[i+1]<array[i]||array[i-1]>array[i];
	  }
	
	  
}
