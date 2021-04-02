package collections;

import java.util.HashMap;

class Test
{
	int z;
	int y;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	


	@Override
	public String toString() {
		return "Test [z=" + z + ", y=" + y + "]";
	}
	
	
}
public class HashMapEqualsHashCode {

	
	public static void main(String[] args) {
		
		
		HashMap<Test,Integer>map=new HashMap<>();
		Test t1=new Test();
		t1.z=1;
		t1.y=2;
		
		Test t2=new Test();
		t2.z=1;
		t2.y=2;
		map.put(t1,1);
		map.put(t2,2);
		
		System.out.println(map);
	}

}
