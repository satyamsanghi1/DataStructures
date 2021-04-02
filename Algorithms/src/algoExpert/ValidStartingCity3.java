package algoExpert;
//Greedy
public class ValidStartingCity3 {
	//AlgoExpert solution
	//Time -> (O)N^2
	public static void main(String[] args) {

		int distances[]=new int [] {3,4,5,1,2};
		int fuel[]     =new int [] {1,2,3,4,5};
		int mpg=1;

		int ans=validStartingCity(distances, fuel, mpg);
		System.out.println("ans "+ans);
	}
	public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

		/*
		 * BRUTE FORCE APPROACH
		 */
		int numberOfCities=distances.length;
		
		for(int startCityIdx=0;startCityIdx<numberOfCities;startCityIdx++) {
			
			int milesRemaining=0;
			
			for(int currentCityIdx=startCityIdx;currentCityIdx<(startCityIdx+numberOfCities);
					currentCityIdx++){
				
				if(milesRemaining<0)
					continue;
				
				int currentCityIdxRotated=currentCityIdx%numberOfCities;
				int fuelFromCurrentCity=fuel[currentCityIdxRotated];
				int distanceToNextCity=distances[currentCityIdxRotated];
				
				milesRemaining+=(fuelFromCurrentCity*mpg)-distanceToNextCity;
			}
			if(milesRemaining>=0)
			{
				// sare cities tk pahuch skte hai
				return startCityIdx;
			}
			
		}
	
		return -1;
	}
}
