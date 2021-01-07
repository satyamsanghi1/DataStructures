package binaryHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _347_TopKFrequentElements2 {
	//using inbuilt java priorityQueue for heap
	// time complexity analysis on leetcode
	public static void main(String[] args) {
		
		
		int []nums= {1,1,1,2,2,3};
		
		int a[]=topKFrequent(nums,2);
	
		System.out.println("ans");
		for(int x:a)
			System.out.print(x+" ");
	}
	

    public  static int[] topKFrequent(int[] nums, int k) {
    
    	 Map<Integer, Integer> count = new HashMap<>();
         for (int n: nums) {
           count.put(n, count.getOrDefault(n, 0) + 1);
         }
         //min heap
      // 1. build hash map : character and how often it appears
         // O(N) time
         Queue<Integer>heap=new PriorityQueue<Integer>(
        		 (n1, n2) -> count.get(n1) - count.get(n2));
         
         // 2. keep k top frequent elements in the heap
         // O(N log k) < O(N log N) time
         for(int i :count.keySet())
         {
        	 System.out.println("i "+i);
        	 heap.add(i);
        	 if (heap.size() > k) heap.poll();    
         }
         System.out.println();
         heap.forEach((x)->{
        	 System.out.println("x "+x);
         });
        
         int[] top = new int[k];
      // 3. build an output array
         // O(k log k) time
         for(int i = k - 1; i >= 0; --i) {
             top[i] = heap.poll();
         }
         return top;

    }
  
}
