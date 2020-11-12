package binaryHeap;

public class KthLargestElementInArray {
	
	static int size=0;
	static int heap[];
	
	public static void main(String[] args) {
		
		int a[]= {1, 23, 12, 9, 30, 2, 50};
		
		//Solution 1 modify bubble sort for k times 
		
		//Solution 2 use sorting algos and modify them 
		
		//Solution 3 Build Max heap , and call extractMax k times
		
		
		int k=3;
		heap=createHeap(a.length);
		
		//insert(a[0]);
		
		for(int i=0;i<a.length;i++)
		{
			insert(a[i]);
		}
		System.out.println("traversing");
		traverse(heap);
		System.out.println("size "+size);
		
		//for(int i=1;i<=k;i++)
		//{
			int z=extractMin();
		
			System.out.println(z);
			traverse(heap);
			System.out.println("size "+size);
			
			 z=extractMin();
			
			System.out.println(z);
			traverse(heap);
			
			System.out.println("size "+size);
			
			 z=extractMin();
			
			System.out.println(z);
			traverse(heap);
		//}
		
	}
	public static int [] createHeap(int size)
	{
		int a[]=new int [size+1];
		return a;
	}
	
	public static void insert(int value)
	{
		System.out.println("inserting "+value);
		heap[size+1]=value;
		size++;
		
		heapifyBottomToTop();
		
		
	}
	public static int extractMin()
	{
		System.out.println("extracting");
		int value=heap[1];
		heap[1]=heap[size];
		size--;
		heapifyTopToBottom();
		return value;
	}
	public static void heapifyTopToBottom()
	{
		int i=1;
		int swap;
	
				while(i<size-1)
				{
				
					if(heap[i]>heap[2*i] || heap[i]>heap[(2*i)+1])
					{
				
			if(heap[2*i]<heap[(2*i)+1])
			{
			
				swap=heap[2*i];
				heap[2*i]=heap[i];
				heap[i]=swap;
				
				i=2*i;
				
			}
			else if (heap[2*i]>heap[(2*i)+1])
			{
				swap=heap[(2*i)+1];
				heap[(2*i)+1]=heap[i];
				heap[i]=swap;
				
				i=(2*i)+1;
			}
			
					}
					System.out.println("i "+i);

	}
	}
	
	public static void heapifyBottomToTop()
	{
		int current=0;
		int swap=0;
		int i=size;
		while(i>1)
		{
			current=i;
			System.out.println("current "+current);
			System.out.println("i "+i);
		
			if(i%2==0)
			{
				//even 
				i=i/2;
			}
			else
			{
				// odd
				i=(i-1)/2;
				
			}
			if(heap[current]<heap[i])
			{
				System.out.println("condition true");
				swap=heap[i];
				heap[i]=heap[current];
				heap[current]=swap;
				
			}
		}
	}
	
	public static void traverse(int[] heap)
	{
		for(int i=1;i<=size;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}

}
