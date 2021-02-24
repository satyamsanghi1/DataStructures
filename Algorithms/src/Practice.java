import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {



	public static void main(String[] args) {

		int array[]=new int [] {0,1,2,3};
		
		List<Integer>ar=new ArrayList<>(Arrays.asList(0,1,2,3));
		
	}

	public static void permute(List<Integer>array)
	{
		List<int []>permutations=new ArrayList<>();
		
	}
	
	public static void helper(List<Integer>array,int i)
	{
		
		for(int j=0;j<array.size();j++)
		{
			swap(array, i, j);
			helper(array,j);
			swap(array, i, j);
		}
	}
	
	public static void swap(List<Integer>array,int i,int j)
	{
		int temp=array.get(i);
		array.set(i, array.get(j));
		array.set(j,temp);
	}




}
