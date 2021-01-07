import java.util.HashMap;
import java.util.Map;

public class Practice2 {

	
	public static void main(String[] args) {
		
		Map<Integer,Integer>map=new HashMap<>();
		
		System.out.println(fib(5,map));
	
	}
	
	public static int fib(int n,Map<Integer,Integer>map)
	{
		if(n==1)
			return 0 ;
		
		if(n==2)
			return 1 ;
		
		if(map.containsKey(n))
		{
			System.out.println("here "+n);
			return map.get(n);
		}
		int x= fib(n-1,map)+fib(n-2,map);
		map.put(n,x);
		return x;
	}
}
