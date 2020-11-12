package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
	
	public static void main(String[] args) {
		
		
		//int array[]= {2, 1, 2, 2, 2, 3, 4, 2};
		List<Integer>l=new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
		moveElementToEnd(l,2);
	}
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
	    
		int j=0;
		for(int i=0;i<array.size();i++)
		{
			//finding the non toMove element and swapping it with element at index j
			if(array.get(i)!=toMove)
			{
				System.out.println("here "+i);
				int swap=array.get(j);
				array.set(j,array.get(i));
				array.set(i,swap);
				j++;
			}
		}
		
		for(int i:array)
			System.out.print(i+" ");
    return array;
  }

}
