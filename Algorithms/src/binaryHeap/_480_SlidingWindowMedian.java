package binaryHeap;

import java.util.PriorityQueue;
import java.util.Queue;

public class _480_SlidingWindowMedian {
		//half test cases passed like 295 

	public static void main(String[] args) {

	//	int nums[]=new int[] {1,3,-1,-3,5,3,6,7};
		int nums[]=new int[] {2147483647,2147483647};
		int k=2;

		System.out.println((2147483647+2147483647)/2);
		medianSlidingWindow(nums, k);

	}
	public static double[] medianSlidingWindow(int[] nums, int k) {

		double[]median=new double[nums.length-k+1];
		MedianFinder f=new MedianFinder();
		for(int i=0;i<nums.length;i++)
		{
			f.add(nums[i]);
			if(i>=(k-1))
			{
				System.out.println("lowers "+f.lowers);
				System.out.println("greaters "+f.greaters);
				if(i>=k)
				f.remove(nums[i-k]);
				median[i-k+1]=f.findMedian();
				
				
				
				System.out.println("median at "+nums[i]+" : "+f.findMedian());
			}
			

			System.out.println("------------------");
		}

		return median;
	}
}

class MedianFinder
{
	Queue<Integer>greaters=new PriorityQueue<>();
	Queue<Integer>lowers=new PriorityQueue<>((a,b)->b-a);

	double median=0;
	public void remove(int num)
	{
		if(lowers.contains(num))
		{
			lowers.remove(num);
		}
		else if(greaters.contains(num))
		{
			greaters.remove(num);
		}
		balanceHeap();
		updateMedian();
	}

	public void add(int num)
	{
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
	public double findMedian()
	{
		return median;
	}
}
