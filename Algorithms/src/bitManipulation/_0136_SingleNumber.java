package bitManipulation;

import java.util.Scanner;

public class _0136_SingleNumber {
	
	public static void main(String[] args) {
		
		int nums[]= {2,3,2,3,1};
		System.out.println("answer "+singleNumber(nums));
		
	
		
	}


	 public static int singleNumber(int[] nums) {
	        int a=0;
	        
		 for(int i:nums)
		 {
			//System.out.println(a^0);
			 System.out.println(i+"+ "+Integer.toString(a,2));
			a^=i;
			System.out.println(Integer.toString(a,2));
			System.out.println(); 
		 }
		 return a;
		 
	    }
	 
}
