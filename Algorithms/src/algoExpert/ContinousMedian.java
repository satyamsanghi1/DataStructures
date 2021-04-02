package algoExpert;

import java.util.PriorityQueue;
import java.util.Queue;

public class ContinousMedian {
	// leetcode 295 (91%Fast)
	// algoexpert without built in PriorityQueue class  yet to implement in eclipse

	public static void main(String[] args) {
		
		MedianFinder f=new MedianFinder();
		f.addNum(1);
		f.addNum(2);
		
		System.out.println(f.lowers);
		System.out.println(f.greaters);
		System.out.println(f.findMedian());
	}

	static class MedianFinder {

		/** initialize your data structure here. */
		Queue<Integer>greaters=new PriorityQueue<>();
		Queue<Integer>lowers=new PriorityQueue<>((a,b)->b-a);
		
		double median=0;
		public MedianFinder() {
			
		
		}

		public void addNum(int num) {
			/*
			 * 
			 * 1. decide in which heap the num will be added 
			 * 2.if size difference between heaps is >=2 perform balancing 
			 * 3. update median
			 */
			if(lowers.size()==0 || num<lowers.peek())
				lowers.add(num);
			else
				greaters.add(num);
			
			balanceHeap();
			updateMedian();
		}
		
		public void balanceHeap()
		{
			if(lowers.size()-greaters.size()==2)
			{
				System.out.println("lowers big");
				greaters.add(lowers.poll());
			}
			else if(greaters.size()-lowers.size()==2)
			{
				System.out.println("greaters big");
				lowers.add(greaters.poll());
			}
		}
		public void updateMedian()
		{
			if(lowers.size()==greaters.size())
			{
				median=(double)(lowers.peek()+greaters.peek())/2;
			}
			else if(lowers.size()>greaters.size())
				median=lowers.peek();
			else
				median=greaters.peek();
		}

		public double findMedian() {

			return median;
		}
	}
}
