package StreamsAPIExamples.terminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MinMaxDemo {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<String>();

		stringList.add("abc");
		stringList.add("def");

		

		Optional<String> min = stringList.stream().min(String::compareTo);
		
		
		Optional<String> max = stringList.stream().max((val1, val2) -> {
			return val1.compareTo(val2);
		});

		String minString = min.get();
		String maxString=max.get();
		System.out.println("minString : "+minString+" , maxString : "+maxString);
	}
}
