package algoExpert;
//Greedy
public class ValidStartingCity {
	//mysolution leetcode 134 Gas Station 21%Fast
	//Time -> (O)N^2
	public static void main(String[] args) {

		int distances[]=new int [] {5,25,15,10,15};
		int fuel[]     =new int [] {1,2,1,0,3};
		int mpg=10;

		int ans=validStartingCity(distances, fuel, mpg);
	}
	public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

		int lastCity=distances.length-1;

		int startingCity=0;
		while(startingCity<=lastCity)
		{
			System.out.println("startingCity "+startingCity);
			int currentCity=startingCity;
			int distanceToNextCity=distances[currentCity];
			int fuelAtCurrentCity=fuel[currentCity];
			int milesLeft=mpg*fuelAtCurrentCity;
			int cityCount=0;
			while(milesLeft>=distanceToNextCity && cityCount<distances.length)
			{
				System.out.println("currentCity "+currentCity);
				milesLeft-=distanceToNextCity;
				System.out.println("milesLeft "+milesLeft);
				cityCount++;
				currentCity++;


				if(currentCity>=distances.length)
					currentCity=currentCity%distances.length;

				distanceToNextCity=distances[currentCity];
				fuelAtCurrentCity=fuel[currentCity];
				milesLeft+=mpg*fuelAtCurrentCity;

				System.out.println("____");
			}
			if(cityCount==distances.length)
				return startingCity;

			startingCity++;
			System.out.println("-------------------");
		}
		return -1;
	}
}
