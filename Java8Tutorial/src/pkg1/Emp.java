package pkg1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Dep
{
	String name;

	@Override
	public String toString() {
		return "Dep [name=" + name + "]";
	}
	
	
}
class Hel
{
	int x;
	@Override
	public String toString() {
		return "Hel [x=" + x + ", dep=" + dep + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dep == null) ? 0 : dep.hashCode());
		result = prime * result + x;
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
		Hel other = (Hel) obj;
		if (dep == null) {
			if (other.dep != null)
				return false;
		} else if (!dep.equals(other.dep))
			return false;
		if (x != other.x)
			return false;
		return true;
	}
	Dep dep;
	
	
	
}
public class Emp {

	public static void main(String[] args) {
		
		HashMap<Hel,String>map=new HashMap<>();
		
		Dep dep=new Dep();
		dep.name="satyam";
		
		Hel h=new Hel();
		h.x=1;
		h.dep=dep;
		
		map.put(h,"1");
		
		dep.name="asasd";
		//map.put(h,"2");
		
		System.out.println(map);
		System.out.println(map.size());
		
		
	}

	@Override
	public String toString() {
		return "Emp []";
	}
}
