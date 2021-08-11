package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class FindFirstDemo {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(1,9,4,8,4,6,1);
		
		int firstValue=list.stream().findFirst().get();
		
		System.out.println("first value "+firstValue);
	}
}
