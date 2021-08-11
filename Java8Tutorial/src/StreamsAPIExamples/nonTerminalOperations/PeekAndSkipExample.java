package StreamsAPIExamples.nonTerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekAndSkipExample {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(1,6,2,2,2,7,8,5,4,6,8,9);
		
		//skip example
		List<Integer>l=list.stream().skip(2).collect(Collectors.toList());
		
		System.out.println(l);
		
		list.stream()
		.filter(x->x>3)
		.peek(x->System.out.print("filtered value "+x))
		.map(x->x+10)
		.peek(x->System.out.println("mapped value "+x))
		.collect(Collectors.toList());
		
	}
}
