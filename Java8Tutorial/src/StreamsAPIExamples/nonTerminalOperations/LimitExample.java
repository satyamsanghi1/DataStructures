package StreamsAPIExamples.nonTerminalOperations;

import java.util.ArrayList;
import java.util.List;



public class LimitExample {

	public static void main(String[] args) {
		
		
		List<String>list=new ArrayList<>()
				{
			{
				add("one");add("two");add("three");add("four");
			}
				};
			
		list.stream().limit(2).forEach(System.out::println);
	}
}
