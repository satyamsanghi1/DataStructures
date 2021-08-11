package StreamsAPIExamples.terminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindAnyDemo {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("four");
		
		Optional<String>anyValue=stringList.stream().findAny();
		
		System.out.println(anyValue.get());
	}
}
