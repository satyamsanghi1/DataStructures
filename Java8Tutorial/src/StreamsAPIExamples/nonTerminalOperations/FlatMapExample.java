package StreamsAPIExamples.nonTerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		
		List<List<Integer>>list=Arrays.asList(Arrays.asList(1,5,6,7),Arrays.asList(7,8,9),Arrays.asList(),Arrays.asList(1,2,3));
		
		System.out.println(list);
		
		List<Integer>flattenedList=list.stream()
									   .flatMap(x->x.stream()
											   		.map(z->z+10))
									   .collect(Collectors.toList());
		
		System.out.println(flattenedList);
	}
}
