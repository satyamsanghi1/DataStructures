package binaryHeap;

public class BinaryHeap {
	
	static int size=0;
	static int heap[];
	
	public static void main(String[] args)
	{
		
		 heap=createHeap(20);
		 insert(10);
		 traverse(heap);
		 
		 insert(20);
		 traverse(heap);
		 
		 insert(25); 
		 traverse(heap);
		 
		 insert(30);
		 traverse(heap);
		 insert(5);
		 traverse(heap);
		 
		int y =extractMin();
		System.out.println("extracted value "+y);
		 traverse(heap);
		
		
	}
	
	public static int [] createHeap(int size)
	{
		int a[]=new int [size+1];
		return a;
	}
	
	public static void insert(int value)
	{
		
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
