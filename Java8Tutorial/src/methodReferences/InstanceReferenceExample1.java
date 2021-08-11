package methodReferences;

import java.util.Arrays;
import java.util.List;

public class InstanceReferenceExample1 {

	
	public static void main(String[] args) {
		
		List<Integer>list=Arrays.asList(1,2,3,4,5,6);
		
		Util util=new Util();
		
		list.forEach(util::print);
		
		
		
	}
}

class Util
{
	public  void print(int x)
	{
		System.out.println(x);
	}
}
