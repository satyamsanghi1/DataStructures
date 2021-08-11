package methodReferences;

import java.util.Arrays;
import java.util.List;

public class InstanceReferenceExample2 {

	
	public static void main(String[] args) {
		
		List<String>list=Arrays.asList("abc","baf","asde","qwe");
		
			
		
		list.stream().filter(Pro::check).forEach(System.out::println);
		
	}
}

class Pro
{
	public static boolean check(String s)
	{
		return s.startsWith("b");
	}
}
