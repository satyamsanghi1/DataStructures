package StreamsAPIExamples.nonTerminalOperations;

import java.util.stream.Stream;

public class MapExample {

	public static void main(String[] args) {
		
		Stream<String>str=Stream.of("x","asd","qwe","basd");
		
		str.map(x->x.toUpperCase()).forEach(System.out::println);
		
		
	}
}
