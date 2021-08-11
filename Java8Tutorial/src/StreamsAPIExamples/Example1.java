package StreamsAPIExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Example1 {

	
	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(1,2,3,4,5);
		
		long l=list.stream().filter((i)->i%2==0).count();
		
		
		
		Function<Integer,String>func=x->x.toString();
		
		
		HashMap<Integer,Integer>map=new HashMap<>();
		
		
		
		System.out.println(l);
	}
}
