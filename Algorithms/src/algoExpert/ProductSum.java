package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
	static int sum=0;
	public static void main(String[] args) {
		
		List<Object> test =
		        new ArrayList<Object>(
		            Arrays.asList(
		                5,
		                2,
		                new ArrayList<Object>(Arrays.asList(7, -1)),
		                3,
		                new ArrayList<Object>(
		                    Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
		
		 productSum(test);
	}
	public static int productSum(List<Object> array) {
	    // Write your code here.
		System.out.println("answer "+helper(array,1));
	    return -1;
	  }
	
		public static int helper(List<Object>list,int level)
		{
			int index=0;
			int localSum=0;
			while(index<list.size())
			{
				
				if(list.get(index) instanceof Integer)
				{
					localSum+=(int)list.get(index);
					System.out.println("current "+list.get(index)+" level "+level);
				}
				else
				{
				localSum+=helper((List<Object>)list.get(index), level+1);
				}
				
				index++;
			}
			return localSum*level;
		
			
		}

}
