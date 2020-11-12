package searching_and_sorting;

public class HeapSort {
	
	static int size;
	
	static int a=0;
	public static void main(String[] args) {
		
		int a[]= {10,5,30,15,50,5,25,35,1};
		
		
		int heap[]=createHeap(a.length);
		
		for(int i=0;i<a.length;i++)
		{
			insertHeap(heap, a[i]);
			System.out.println();
		}
		traverse(heap);
		
		System.out.println("extraction starts");
		System.out.println();
		for(int i=0;i<9;i++) {
			System.out.println("extracting");
			a[i]=extractMin(heap);
			System.out.println("traversing sorted array");
			for(int k=0;k<a.length;k++)
			{
				System.out.print(a[k]+" ");
			}	
			System.out.println();
			System.out.print("heap after extraction");
			traverse(heap);
			System.out.println();
			
		
			System.out.println();
		}
		System.out.println();
		
		System.out.println("traversing sorted array");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}	
	
	}
	
	public static int[] createHeap(int length)
	{
		size=0;
		return new int[length+1];
	}
	public static void insertHeap(int heap[],int x)
	{
		System.out.println("inserting "+x);
		size++;
		System.out.println("size "+size);
		heap[size]=x;
		
		heapifyBottomToTop(heap,size);
		
	}
	public static int extractMin(int heap[])
	{
		int x=heap[1];
		heap[1]=heap[size];
		size--;
		heapifyTopToBottom(heap);
		return x;
	}
	
	public static void heapifyTopToBottom(int[] heap)
	{
		
		int i=1;
		System.out.println("top "+heap[i]);
		System.out.println("size "+size);
		int small=0;
		int leftChild=0;
		int rightChild=0;
		while(i<=size )
		{
			if(a==4)
				break;
			if((2*i)<=size)
				{
				leftChild=(2*i);
				}
			if(((2*i)+1)<=size)
			{
				 rightChild=((2*i)+1);
			}
		
			 
			 
			System.out.println("left "+heap[leftChild]+" right "+heap[rightChild]);
		
			if(leftChild!=0 && rightChild!=0)
			 small=heap[leftChild]<=heap[rightChild]?leftChild:rightChild;
			
			else if(leftChild!=0)
				small=heap[leftChild];
			else if(rightChild!=0)
				small=heap[rightChild];
			else
				break;
			System.out.println("small index "+small);
			if(heap[small]<=heap[i])
			{
				System.out.println("condtion");
				swap(heap,small,i);
				i=small; 
				System.out.println("i "+i);
			}
			else
				break;
			a++;
		}
		
	}
	public static void swap(int []heap,int a ,int b)
	{
		int  swap=0;
		swap=heap[a];
		heap[a]=heap[b];
		heap[b]=swap;
	}
	public static void heapifyBottomToTop(int[] heap,int index)
	{
		//System.out.println("here index "+index);
		int i=0;
		int swap=0;
		while(index>=1)
		{
			i=index;
			System.out.println("calls");
			if(index%2==0)
			{
				//i=index/2;
				index=index/2;
			}
			else 
			{
				//i=(index-1)/2;
				index=(index-1)/2;
				
			}
			System.out.println("i "+i+" index "+index);
			if(heap[i]<=heap[index])
			{
				System.out.println("issue");
				swap=heap[i];
				heap[i]=heap[index];
				heap[index]=swap;
			}
			
		}
		
	}
	
	public static void traverse(int []heap)
	{
		System.out.println();
		
		for(int i=1;i<=size;i++)
		{
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}

}
