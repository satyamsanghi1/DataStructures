package StreamsAPIExamples.terminalOperations;

import java.util.Arrays;
import java.util.List;

public class AnyMatchDemo {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(1,6,2,2,2,7,8,5,4,6,8,9);
		
		//atleast one even number
		
		boolean containsEven=list.stream().anyMatch(x->x%2==0);
		System.out.println(containsEven);
		
		
		
	}
}
