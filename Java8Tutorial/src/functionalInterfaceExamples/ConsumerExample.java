package functionalInterfaceExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	
	public static void main(String[] args) {
		
		Consumer c= x->System.out.println(x);
		
		List<Integer>list=Arrays.asList(1,2,3,4,5);
		
		
		//forEach accepts a consumer
		list.forEach(c);
		
		
	}
}
