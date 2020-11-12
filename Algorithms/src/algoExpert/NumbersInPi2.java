package algoExpert;

import java.util.Arrays;
import java.util.HashMap;

public class NumbersInPi2 {
	
	 public static void main(String[] args) {
		
		 String pi="3141592";
		 
		 String numbers[]= {"3141",
				    "5",
				    "31",
				    "2",
				    "4159",
				    "9",
				    "42","4"
				    };
		 
		numbersInPi(pi, numbers); 
		 
	}
	 public static int numbersInPi(String pi, String[] numbers) {
		 //not working
		 
		 int dp[]=new int [pi.length()+1];
		 Arrays.fill(dp,Integer.MAX_VALUE);
		 dp[0]=0;
		 HashMap<String,Boolean>map=new HashMap<>();
		 
		 for(String s:numbers)
		 {
			 map.putIfAbsent(s,false);
		 }
		 
		 
		 for(Integer i=1;i<dp.length;i++)
		 {
			 System.out.println("at "+i);
			 //checking if already used 
		/*	 for(String s:numbers)
			 {
				 if(s.startsWith(pi.charAt(i-1)+""))
				 {
					 System.out.println("here");
					 if(map.get(s))
					 {
						 dp[i]=dp[i-1];
						break;
					 }
				 }
			 }*/
			 for(int k=i;k>=1;k--)
			 {
				 System.out.println(pi.substring(k-1,i)+ " at k "+k);
				 if(map.containsKey(pi.substring(k-1,i)))
				 {
					
					map.put(pi.substring(k-1,i), true);
					
					 System.out.println("prev dp "+(dp[k-1]+1));
					 if(k==1)
					 dp[i]=Math.min(dp[k-1],dp[i]);
					 else
					 {
						 dp[i]=Math.min(dp[k-1]+1,dp[i]);
					 }
					// System.out.println(pi.substring(k,i));
				 }
				
			 }
			
			/* if(dp[i]==Integer.MAX_VALUE)
			 {
				 dp[i]=dp[i-1];
			 }*/
			 traverse(dp);
			
			 System.out.println("-----------------------");
		 }
		    // Write your code here.
		 if( dp[dp.length-1]!=Integer.MAX_VALUE )
		 {
			 return dp[dp.length-1];
		 }
		 return -1;
		  }
	 public static void traverse(int a[])
	 {
		 for(int o:a)
			 System.out.print(o+" ");
		 System.out.println();
	 }

}
