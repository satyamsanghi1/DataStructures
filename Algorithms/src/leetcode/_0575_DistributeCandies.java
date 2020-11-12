package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class _0575_DistributeCandies {
	
	public static void main(String[] args) {
		
		int candies[]= {0,0,14,0,10,0,0,0};
		
		//distributeCandies(candies);
		
		distributeCandies(candies);
	}
	 public static int distributeCandies(int[] candies) {
		 
		 HashSet<Integer>set=new HashSet<>();
		 int n=candies.length;
		 int sis=0;
		 
		 for(int i:candies)
		 {
			 if(!set.contains(i))
			 {
				 set.add(i);
				 sis++;
				 // or set size equal to half of array length
				 if(sis==n-sis)
					 break;
			 }
		 }
		 System.out.println("sis "+sis);
		 return sis;
	 }
	

}
