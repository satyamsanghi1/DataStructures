package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _179_LargestNumber {
	
	public static void main(String[] args) {
		
	
		
		int nums[]=new int [] {3,30,34,5,9};
		
		String s1="12";
		String s2="21";
		System.out.println(s1.compareTo(s2));
		largestNumber(nums);
		
	}
	 public static String largestNumber(int[] nums) {
	        
	        
	        List<String>s=new ArrayList<>();
	        
	        for(int i:nums)
	        {
	        	s.add(Integer.toString(i));
	        	
	        	
	        }
	        
	        Comparator comp=new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					
					String case1=o1+o2;
					String case2 =o2+o1;
					
					return case2.compareTo(case1);
				}
			};
	        
			s.sort(comp);
			
			StringBuilder sb=new StringBuilder();
			for(String s1:s)
				sb.append(s1);
			System.out.println(s.toString());
	        return null;
	    }

}
