package StreamsAPIExamples.terminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ToArrayDemo {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		Stream<String> stream = stringList.stream();

		String objects[]=	stream.toArray(size->new String[size]);
		
		String object[]=	stream.toArray(String[]::new);
		
		Stream.of(objects).forEach(System.out::println);
	}
}
