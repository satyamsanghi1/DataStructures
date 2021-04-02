package algoExpert;
//Greedy
public class ValidStartingCity2 {
	//AlgoExpert solution
	//Time -> (O)N
	public static void main(String[] args) {

		int distances[]=new int [] {3,4,5,1,2};
		int fuel[]     =new int [] {1,2,3,4,5};
		int mpg=1;

		int ans=validStartingCity(distances, fuel, mpg);
		System.out.println("ans "+ans);
	}
	public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

		/*
		 *  jis city pe sabse kam fuel hai ,wahi h starting city 
		 *  becoz , fuel sare cities tk pahuchne k lie hai
		 *  jis city tk bhot sarei cities se pachuch hi ni pare hai , wahi hai starting
		 *  city
		 * 
		 * GREEDY -> har bar wo city dekre hai jisme sabse less fuel bacha hai
		 */

		int numberOfCities=distances.length;

		int milesRemaining=0;
		int indexOfStartingCityCandidate=0;
		int milesRemainingAtStartingCityCandidate=0;

		for(int cityIdx=1;cityIdx<numberOfCities;cityIdx++)
		{
			int fuelFromPrevCity=fuel[cityIdx-1];
			int distanceFromPrevCity=distances[cityIdx-1];

			milesRemaining+=(fuelFromPrevCity*mpg)-distanceFromPrevCity;

			System.out.println("mile remain "+milesRemaining+" at "+cityIdx);
			if(milesRemaining<milesRemainingAtStartingCityCandidate)
			{
				milesRemainingAtStartingCityCandidate=milesRemaining;
				indexOfStartingCityCandidate=cityIdx;
			}

		}
		//checking if solution exist or not 
		/*
		 * if the milesRemaining is 0 at the end . that means there is a solution
		 * else not 
		 */
		milesRemaining+=fuel[fuel.length-1];
		milesRemaining-=distances[distances.length-1];
		System.out.println("milesRemain "+milesRemaining);
		return milesRemaining<0?-1:indexOfStartingCityCandidate;
		//	return indexOfStartingCityCandidate;
	}
}
