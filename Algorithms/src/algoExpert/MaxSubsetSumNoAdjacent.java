package algoExpert;

public class MaxSubsetSumNoAdjacent {
	
	//LETCODE 198
	public static void main(String[] args) {
		
		int array[]= {75,105,120,75,90,135};
		maxSubsetSumNoAdjacentAlter1(array);
	}
	public static int maxSubsetSumNoAdjacentAlter1(int[] array) {
		// best solution algo expert 
		  // wihtout extra space 
		    
		
		//first is the prevouse element ( i-1)
		  int first=0;
		  //second is i-2 element
		  int second=0;
		  int current=0;
		    for(int i=0;i<array.length;i++)
		    {
		    	System.out.println("curent "+i);
		    
		    /*
		     * our formula is 
		     * 
		     * current=Max ( prevous element , current element + (i-2)element)
		     * (i-2) becaouse it would be adjacenet and it would be max sum till then 
		     * 
		     * 
		     * i-1 will be first 
		     * i-2 will be second 
		     * 	
		     */
		    	 current=Math.max(first,second+array[i]);
	// first is i-1 , second =fisrt beacouse in next iter second will i-2 	    	 
		    	second=first;
		    	//as current is i we update first as i becaouse in next iter first will be i-1
		    	first=current;
		    	
		    	System.out.println();
		    }
		    System.out.println(current);
		    return -1;
		  }
	public static int maxSubsetSumNoAdjacent(int[] array) {
	  
		// with extra space 
		// calculating max sum at every index from 0 to current 

	    int max[]=new int[array.length];
			
	    max[0]=array[0];
	   
	    for(int i=1;i<array.length;i++)
	    {
	    	System.out.println("curent "+i);
	    	int prevAdjacentSum=0;
	    	if(i-2>=0)
	    	{
	    	 prevAdjacentSum=max[i-2];
	    	 System.out.println("prevAdjacentSum "+prevAdjacentSum);
	    	}
	    	int current=prevAdjacentSum+array[i];
	    	
	    	
	    	max[i]=Math.max(max[i-1],current);
	    	System.out.println(max[i]);
	    	System.out.println();
	    }
	    return max[max.length-1];
	  }
	
	public static int maxSubsetSumNoAdjacentAlter(int[] array) {
	  // wihtout extra space 
	    
	   int maximum=array[0];	 
	   int lastOdd=0;
	   int lastEven=array[0];
	    for(int i=1;i<array.length;i++)
	    {
	    	System.out.println("curent "+i);
	    	int prevAdjacentSum=0;
	    	
	    	if(i%2==0)
	    	{
	    		prevAdjacentSum=lastEven;
	    	}
	    	else
	    	{
	    		prevAdjacentSum=lastOdd;
	    	}
	    	int current=prevAdjacentSum+array[i];
	    	
	    	
	    	maximum=Math.max(maximum,current);
	    	if(i%2==0)
	    		lastEven=maximum;
	    	else
	    		lastOdd=maximum;
	    	System.out.println(maximum);
	    	System.out.println();
	    }
	    return -1;
	  }
	
	

}
