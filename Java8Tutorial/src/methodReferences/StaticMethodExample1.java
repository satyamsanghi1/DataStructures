package methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaticMethodExample1 {

	public static void main(String[] args) {
		
		
		List<String>l=Arrays.asList("1","2","3","4","5");
		
		
		
		l.stream().forEach((x)->Utility.print(x));//lambda expression
		
		l.stream().forEach(Utility::print);
		
		l.stream().forEach(System.out::print);
	}
}
class Utility
{
	public static void print(String x)
	{
		System.out.println(x);
	}
}
