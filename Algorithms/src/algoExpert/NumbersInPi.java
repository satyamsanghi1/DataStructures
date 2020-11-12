package algoExpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumbersInPi {
	//top down usig memoization
	 public static void main(String[] args) {
		

		 String pi="3141592";
		 
		 String numbers[]= {"3141",
				    "5",
				    "31",
				    "2",
				    "4159",
				    "9",
				    "42"
				    };
		 
		int ans=numbersInPi(pi, numbers); 
		System.out.println("ans "+ans);
		 
	}
	 public static int numbersInPi(String pi, String[] numbers) {
		 
		 /*Time (O)N 3
		  * N2 for for loop 
		  * and N for substring 
		  * 
		  * +M ( for storing numberss in set)
		  * 
		  * Space( N+M)
		  * 
		  */
		 
		 HashMap<Integer,Integer>cache=new HashMap<>();

		 Set<String>set=new HashSet<>();
		 for(String s:numbers)
		 {
			set.add(s);
		 }
		int ans= helper(pi,set ,cache, 0);
		//System.out.println("ans "+ans);
		return ans==Integer.MAX_VALUE?-1:ans;
		  }
	 
	 public static int helper(String pi,Set<String>set,HashMap<Integer,Integer>cache,int start)
	 {
		 if(start==pi.length())
			 return -1;
		 
		 if(cache.containsKey(start))
		 {
			 System.out.println("here");
			 return cache.get(start);
		 }
		 int minSpaces=Integer.MAX_VALUE;
		 for(int i=start;i<pi.length();i++)
		 {
			 if(set.contains(pi.subSequence(start,i+1)))
			 {
				 System.out.println("at "+i+" , "+pi.subSequence(start,i+1));
				 System.out.println("-------------");
				int minSpaceInSuffix= helper(pi,set,cache,i+1);
				
				if(minSpaceInSuffix==Integer.MAX_VALUE)//overflow when we cannot reach the end
				{
					minSpaces=Math.min(minSpaceInSuffix,minSpaces);
				}
				else
				minSpaces=Math.min(minSpaceInSuffix+1,minSpaces);
				System.out.println("min "+minSpaces+ " at "+i);
			 }
 
		 }
		 cache.put(start,minSpaces);
		 cache.forEach((k,v)->{System.out.println("k "+k+" v "+v);});
		 System.out.println("minSpaces "+minSpaces);
		 
		 return minSpaces;
	 }
	 public static void traverse(int a[])
	 {
		 for(int o:a)
			 System.out.print(o+" ");
		 System.out.println();
	 }

}
