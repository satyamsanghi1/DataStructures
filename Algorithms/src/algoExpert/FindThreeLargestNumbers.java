package algoExpert;

public class FindThreeLargestNumbers {

	public static void main(String[] args) {
		
					
	}
	 public static int[] findThreeLargestNumbers(int[] array) {
			int first=Integer.MIN_VALUE;
			int second=Integer.MIN_VALUE;
			int third=Integer.MIN_VALUE;
			for(int i:array)
			{
				if(i>first)
				{
					third=second;
					second=first;
					first=i;
				
				}
				else if(i>second)
				{
					third=second;
					second=i;
				}
				else if(i>third)
				{
					third=i;
				}
			}
			return new int[]{third,second,first};
			
	  }
}
