package searching_and_sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {

		int a[] = { 170,45,75,90,};

		/*
		 * int n = a.length; radixsort(a, n); print(a, n);
		 */

		
		  for(int i=1;i<=100;i*=10) {
		  
		  System.out.println("before sorting array"); for(int j=0;j<a.length;j++) {
		  System.out.print(a[j]+" "); } System.out.println(); countingSort(a,i);
		  
		  
		  System.out.println(); }
		  
		  System.out.println("\n\n Sorted array"); for(int j=0;j<a.length;j++) {
		  System.out.print(a[j]+" "); }
		 
	}

	static void radixsort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);

	}

	static void countSort(int arr[], int n, int exp) {
		System.out.println();
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		System.out.println("Incremented array");
		for (int q = 0; q < count.length; q++) {
			System.out.print(count[q] + " ");

		}

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		System.out.println("\nadded array");
		for (int q = 0; q < count.length; q++) {
			System.out.print(count[q] + " ");

		}
		System.out.println();

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			int val = arr[i] / exp % 10;
			System.out.print("\n value " + arr[i] + " , index in count is " + val);

			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	public static int[] countingSort(int a[], int x) {
		int c[] = new int[a.length + 1];
		System.out.println("x " + x);
		int b[] = new int[10];
		// int c[]=new int[a.length+1];
		for (int i = 0; i < a.length; i++) {

			int val = (a[i] / x) % 10;

			System.out.println(a[i] + "/" + x + " : " + val);
			b[val]++;

			/*
			 * if(a[i]/x>0) { System.out.println("in if");
			 * System.out.println(a[i]+"%"+x+" : "+a[i]/); b[a[i]%x]++; }
			 */
		}
		System.out.println("Incremented array");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");

		}

		for (int i = 1; i < b.length; i++) {
			b[i] = b[i - 1] + b[i];
		}
		System.out.println("\n");
		System.out.println("added array");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");

		}
		System.out.println("\n");

		for (int i = a.length - 1;i >= 0; i--) {
			int val = (a[i] / x) % 10;

			System.out.println("\n value " + a[i] + " , index in b is " + val);
			System.out.print("value at " + val + " in b " + b[val]);
			c[b[val]] = a[i];
			b[val]--;

		}
		for (int i = 0; i < a.length; i++) {
			a[i] = c[i + 1];

		}
		System.out.println("\n");

		System.out.println("after sorting array");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();

		return c;

	}

	// A utility function to print an array
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
