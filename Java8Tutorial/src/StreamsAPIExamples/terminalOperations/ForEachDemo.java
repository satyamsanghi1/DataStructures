package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(2,4,6,8,10);
		
		list.stream().forEach(x->System.out.print(x+" "));
	}
}
