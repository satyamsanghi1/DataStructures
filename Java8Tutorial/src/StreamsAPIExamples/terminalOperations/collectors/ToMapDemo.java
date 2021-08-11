package StreamsAPIExamples.terminalOperations.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapDemo {

	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Map<Integer,Integer>map=list.stream().collect(Collectors.toMap(x->x+5,x->x+15));
		
		System.out.println("map "+map);
	}
}

