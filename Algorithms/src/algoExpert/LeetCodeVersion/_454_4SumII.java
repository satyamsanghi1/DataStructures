package algoExpert.LeetCodeVersion;

import java.util.HashMap;

public class _454_4SumII {
	
	public static void main(String[] args) {
		
		
		int A[]=		{0,1,-1};
		int B[]=		{-1,1,0};
		int C[]=		{0,0,1};
		int D[]=		{-1,1,1};
		
		fourSumCount(A, B, C, D);
	}
	 public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        int values=0;
	        HashMap<Integer,Integer>map=new HashMap<>();
	        for(int i=0;i<C.length;i++)
	        {
	        	for(int k=0;k<D.length;k++)
	        	{
	        		int sum=C[i]+D[k];
	        	int val=map.getOrDefault(sum,0);
	        	map.put(sum,++val);
	        	}
	        }
	        
	        map.forEach((k,v)->System.out.println("k "+k+" v "+v));
	        for(int i=0;i<A.length;i++)
	        {
	        for(int j=0;j<B.length;j++)
	        {
	            
	         //   for(int k=0;k<C.length;k++)
	            //{
	                
	               // for(int l=0;l<D.length;l++)
	                //{
	                int sum=A[i]+B[j];
	                int diff=0-sum;
	                if(map.containsKey(diff))
	                {
	                	values+=map.get(diff);
	                }
	                
	                //}
	           // }
	        }
	        }
	        System.out.println("values "+values);
	        return values;
	    }

}
