package interview;

import java.util.HashMap;

class Engine
{
	String engineType;

	@Override
	public String toString() {
		return "Engine [engineType=" + engineType + "]";
	}

}
final class Car
{
	final private Engine engine;
	public Engine getEngine() {
		{
		//performing deep copy
			Engine x=new Engine();
			x.engineType=this.engine.engineType;
			return x;
		}
	}
	public String getBrand() {
		return brand;
	}
	final private String brand;


	Car (Engine engine,String brand)
	{
		//deep copy in constructor 
		Engine x=new Engine();
		x.engineType=engine.engineType;
		this.engine=x;
		this.brand=brand;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
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
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", brand=" + brand + "]";
	}


}

public class ImmutableHashMapDeepCopy {

	public static void main(String[] args) {

		Engine e=new Engine();
		e.engineType="Petrol";

		Car c=new Car(e,"maruti");

		HashMap<Car,Integer>map=new HashMap<>();

		map.put(c,1);
		//when there the car class is not made immutable
		//uncommenting below line will change the key 
		//e.engineType="Diesel";

		//even after making car immutable
		//the key can change
		//Engine ex=c.getEngine();
		//ex.engineType="Diesel";

		/*InOrder to solve above problem we perform deep copy in 
		 * getters and constructor
		 */
		
		//getter is solved 
		Engine ex=c.getEngine();
		ex.engineType="deisel";
		
		e.engineType="diesel";
		//we have succuessfull made the car as immutable key
		System.out.println(map);

	}
}
