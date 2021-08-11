package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectDemo {

	public static void main(String[] args) {
		

		List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9,8,7,6,5);
		
		List<String>l=list.stream().map(x->Integer.toString(x)).collect(Collectors.toList());
		
		System.out.println("String list : "+ l);
		Set<Integer>set=list.stream().collect(Collectors.toSet());
		
		System.out.println("set "+set);
		
	}
}
