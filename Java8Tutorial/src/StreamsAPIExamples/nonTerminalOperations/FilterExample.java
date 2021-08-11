package StreamsAPIExamples.nonTerminalOperations;

import java.util.stream.Stream;

public class FilterExample {

	public static void main(String[] args) {
		
		
		Stream<String>str=Stream.of("abc","adsasd","cdg","wqer","vcx");
		
			str.filter(x->x.length()<=3).forEach(System.out::println);
		
	}
}
