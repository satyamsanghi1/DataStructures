package methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StaticMethodExample3 {

	public static void main(String[] args) {


		
		System.out.println(method1(1,2,Utils::combine));
		
		
	}
	
	
	public static String method1(int x,int y,BiFunction<Integer,Integer,String>func)
	{
		return func.apply(x, y);
	}
}
class Utils
{
	public static String combine(int x,int y)
	{
		return String.valueOf("joined String is : "+(x+y));
	}
}

