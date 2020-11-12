package leetcode;

public class _088_MergeSortedArray {
	
	
	/// we can also solve by backwards loooking for which is greater 
	// by this approach wedont need to create a new array 
	
	public static void main(String[] args) 
	{
		
		//int nums1[] = {1,2,3,0,0,0}; // m =3
		//int nums2[] = {2,5,6};
		int nums1[] = {2,0}; // m =3
		int nums2[] = {1};
		
	//	merge(nums1,1, nums2,nums2.length);
		
		alter(nums1,1, nums2,1);
		
		
	}
	public static void alter(int[] nums1, int m, int[] nums2, int n)
	{
		/// checking greatest element // behind approach
		
		int k=m; // for nums1
		int q=n; // for nums2
		int i=0;
		
		int current=nums1.length-1;
		
		while(k>0 && q>0)
		{
			System.out.println("k "+k);
			System.out.println("q "+q);
			if(nums1[k-1]<nums2[q-1])
			{
				System.out.println("here");
				nums1[current]=nums2[q-1];
				current--;
				q--;
			}
			else
			{
				System.out.println("in else");
				nums1[current]=nums1[k-1];
				current--;
				k--;
			}
			System.out.println();
		}
		System.out.println("After loop");
		System.out.println("k "+k);
		System.out.println("q "+q);
		System.out.println("current "+current);
		while(q>0)
		{
			nums1[current]=nums2[q-1];
			current--;
			q--;
		}
		
		for(int x:nums1)
			System.out.print(x+" ");
		
	}
		public  static void merge(int[] nums1, int m, int[] nums2, int n) 
		{
			
			int a[]=new int[m+n];
			
			
			int k=0; // for nums1
			int q=0; // for nums2
			int i=0;
			
			while(q<n && k<m )
			{
				if(nums1[k]<nums2[q])
				{
					a[i]=nums1[k];
					k++;
				}
				else if(nums2[q]<nums1[k])
				{
					a[i]=nums2[q];
					q++;
				}
				else if(nums1[k]==nums2[q])
				{
					a[i]=nums1[k];
					a[++i]=nums2[q];
					k++;
					q++;
				}
				i++;
			}
			System.out.println("q "+q);
			System.out.println("k "+k);
			System.out.println("i "+i);
		
			
			while(q<n)
			{
				a[i]=nums2[q];
				i++;
				q++;
			}
			while(k<m)
			{
				a[i]=nums1[k];
				i++;
				k++;
				}
			if(nums2.length>0)
			for(int w=0;w<a.length;w++)
			{
				nums1[w]=a[w];
			}
			
			System.out.println("sorted array");
			
			for(int x:nums1)
				System.out.print(x+" ");
	    }

}
