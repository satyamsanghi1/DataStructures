package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class NoneMatchDemo {

	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(2,4,6,8,10);
		//all should be even
		
		boolean allOdd=list.stream().noneMatch(x->x%2!=0);
		System.out.println(allOdd);
		
	}
}
