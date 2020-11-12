package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _658_Find_K_ClosestElements {
	
	//this question has alter solution

	public static void main(String[] args) {

		int arr[] = {22,30,35,39,42,45};

		KClosest(arr,-1, 4);

	}


	public static void KClosest(int arr[], int x, int k) {
		
		

		///Sorting arr on the basis of absolute difference between 
		// arr[i] and x ;
		
		
		int count[] = new int[arr.length];

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int q = x - arr[i];
			if (q >= 0)
				count[i] = q;
			else
				count[i] = -q;
		}

		System.out.println("Traversing count array");

		for (int n : count)
			System.out.print(n + " ");
		System.out.println();
		int swap1 = 0;
		int swap2 = 0;

		for (int w = 0; w < count.length - 1; w++)
			for (int i = 0; i < count.length - 1; i++) {
				if (count[i + 1] < count[i]) {
					swap1 = count[i];
					count[i] = count[i + 1];
					count[i + 1] = swap1;

					swap2 = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = swap2;

				}
			}

		System.out.println("Traversing count array ");

		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + " ");
			System.out.println(arr[i] + " ");

			
		}
		int p=0;
		for (int i = 0; i < count.length; i++) 
		{
			
		
			
				if(p==k)
					break;
				
				
				list.add(arr[i]);
				
				p++;
			
		
		}

		
		  System.out.println("Traversing list");
		  Collections.sort(list);
		  for(int n:list) System.out.print(n+" ");
		 

	}

}
