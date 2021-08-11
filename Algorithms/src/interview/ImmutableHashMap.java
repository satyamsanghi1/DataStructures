package interview;

import java.util.HashMap;

final class Department
{
	final private String depName;
	
	Department(String depName)
	{
		this.depName=depName;
	}
	
	public String getDepName() {
		return depName;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depName == null) ? 0 : depName.hashCode());
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
		Department other = (Department) obj;
		if (depName == null) {
			if (other.depName != null)
				return false;
		} else if (!depName.equals(other.depName))
			return false;
		return true;
	}
	
}
public class ImmutableHashMap {

	public static void main(String[] args) {
	
		Department d=new Department("Computer");
		HashMap<Department,Integer>map=new HashMap<>();
		
		map.put(d,1);
		
	}
}
