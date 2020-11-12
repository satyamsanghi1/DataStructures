package algoExpert;

import java.util.Arrays;
import java.util.Collections;

//medium
public class SmallestDifference {

	public static void main(String[] args) {
		
		int arrayOne[]= {-1,5,10,20,28,3};
		
		int arrayTwo[]= {26,134,135,15,17};
		//int arrayOne[]= {240, 124, 86, 111, 2, 84, 954, 27, 89};
		
		//int arrayTwo[]= {1, 3, 954, 19, 8};	
		
		//smallestDifference(arrayOne, arrayTwo);
		smallestDifferenceAlter(arrayOne, arrayTwo);
	}
	public static int[] smallestDifferenceAlter(int[] arrayOne, int[] arrayTwo) {
	
		// time xomplexity - O(nlogn)+O(mlong(m))
		
		//nlogn for sorting
		// space complexity - o(1)
		
		  Arrays.sort(arrayOne);
		  Arrays.sort(arrayTwo);
		 int ansArray[]=new int[2];
		  int i=0;// pointer for arrayone
		  int j=0; // pointer for array two
		  
		  // our task is to make element at i and j to be equal 
		  // if they are equal than 	the absolute differene between then would be 0
		
		  // let x3 be the third element in array One
		  //let y5 be the 5th element in array two
		  // now if x3==y5 absolute differene is 0 , we have find our pair 
		  //now how to find next pair
		  //if x3<y5 increase pointer in arrayOne to x4  becaouse before x3 all element will be small than y5
		  // if y5<x3 increase pointer in arryTwo to y6 becacouse before y5 all element will be smaller than x3
		  // increment pointer will increase the value as the arrays are sorted 
		 
		  int minDiff=Integer.MAX_VALUE;
		  
		  while(i<arrayOne.length && j<arrayTwo.length)
		  {
				int diff=Math.abs(arrayOne[i]-arrayTwo[j]);
				int a=arrayOne[i];
				int b=arrayTwo[j];
				System.out.println(" min "+diff+" min "+minDiff);
				if(diff<minDiff)
				{
					System.out.println("updating "+arrayOne[i]);
					minDiff=diff;
				ansArray[0]=arrayOne[i];
				ansArray[1]=arrayTwo[j];
				}
				if(a<b)
				{
					System.out.println("increasing i");
					i++;
				}
				else if(b<a)
				{
					System.out.println("increasing j");
					j++;
				}
				else
				{
					System.out.println("equal case");
					i++;
					j++;
				}
				System.out.println("a "+a+" b "+b);
				//break;
				System.out.println();
		  }
	
		  
		  System.out.println("ans "+minDiff);
		  System.out.println("arra "+ansArray[0]+" , "+ansArray[1]);
		  
		  return null;
	}
	 
}
