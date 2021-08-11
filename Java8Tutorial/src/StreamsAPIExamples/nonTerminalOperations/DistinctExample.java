package StreamsAPIExamples.nonTerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(1,1,1,2,3,4,5,5);
		
		List<Integer>distinctList=list.stream().distinct().collect(Collectors.toList());
		
		System.out.println(distinctList);
	}
}
