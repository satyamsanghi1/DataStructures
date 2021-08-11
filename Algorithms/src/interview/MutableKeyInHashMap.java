package interview;

import java.util.HashMap;

class Emp
{
	String name;

	
	@Override
	public String toString() {
		return "Emp [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class MutableKeyInHashMap {

	public static void main(String[] args) {
		
		Emp e=new Emp();
		e.name="satyam";
		
		HashMap<Emp,String>map=new HashMap<>();
		
		map.put(e,"1");
		
		e.name="sanghi";
		
		//key is changed that was referring to value 1 
		//hence it should be immutable
		map.put(e,"2");
		
		System.out.println(map);
	}
}
