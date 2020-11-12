package leetcode;

public class _0507_PerfectNumber {
	
	public static void main(String[] args) {
		
		/// Apply euclid euler theorem 
		checkPerfectNumber(8);
	}

	public static boolean checkPerfectNumber(int num) {

		int sum=0;
		
		for(int i=1;i<num;i++)
		{
			if(num%i==0) {
				System.out.println("i "+i);
				sum+=i;
			}
			}
		System.out.println("sum "+sum);
		if(sum!=num)
			return false;
		return true;
	}
	 
}
