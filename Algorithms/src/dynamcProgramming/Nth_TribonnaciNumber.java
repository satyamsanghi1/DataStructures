package dynamcProgramming;

public class Nth_TribonnaciNumber {
	
	public static void main(String[] args) {
		//nth tribonacci number is the sum of last three digits 
		
			System.out.println(tribonacci(4));
	}
	 public static int tribonacci(int n) {
		 
		  int first=1;
	        int second=1;
	        int third=0;
	        int current=0;
	        for(int i=3;i<=n;i++)
	        {
	            //a[i]=a[i-3]+a[i-2]+a[i-1];
	            
	             current=first+second+third;
	             System.out.println("at i " +i+" " + "current  "+current);
	             third=second;
	             second=first;
	             first=current;
	            
	            System.out.println("first "+first +" second "+second+" third "+third);
	        }
	   
		 return 0;
	 }

}
