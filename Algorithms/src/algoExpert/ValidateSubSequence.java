package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ValidateSubSequence {
	
	public static void main(String[] args) {
		
		List<Integer>array=new ArrayList<>(Arrays.asList(5,1,22,25,6,-1,8,10));
		
		List<Integer>sequence=new ArrayList<>(Arrays.asList(1,6,-1,10));
		System.out.println(isValidSubsequence(array, sequence));
		
		String a="sa";
		String b="sa";
		HashSet<String>set=new HashSet<String>();
		set.add(a);
		set.add(b);
		System.out.println(set);
		
	}
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		 // Write your code here.
		
		if(sequence.size()==0)
			return false;
		if(array.equals(sequence))
			return true;
		
		if(sequence.size()==1 && array.indexOf(sequence.get(0))!=-1)
				return true;
		int sequence_pointer=0;
		for(int i=0;i<array.size();i++)
		{
		if(sequence_pointer<sequence.size() && array.get(i)==sequence.get(sequence_pointer))
			sequence_pointer++;
		}
		if(sequence_pointer==sequence.size())
			return true;
    return false;
	  }

}
