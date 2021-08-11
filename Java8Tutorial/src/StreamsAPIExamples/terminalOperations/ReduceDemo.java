package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(1,2,3,4,5);
		
	
		int sum=list.stream().reduce(0,(ans,b)->ans+b);
		
		list.stream().reduce(Integer::sum);
		
		
		
		
		int sum1=list.stream().mapToInt(i->i).sum();
		System.out.println(sum1);
	}
}
