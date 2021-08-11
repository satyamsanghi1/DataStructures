package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class CountDemo {

	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(2,4,6,8,10);
		
		long numberOfElements=list.stream().filter(x->x>3).count();
		
		System.out.println(numberOfElements);
	}
}
