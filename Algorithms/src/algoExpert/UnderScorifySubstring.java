package algoExpert;

import java.util.ArrayList;
public class UnderScorifySubstring {
	
	
	
	public static void main(String[] args) {
		
		/*
		 * Algorithm :
		 * Step1  : getLocations 
		 * 			a)our first step is to find all the locations of instance of substring
		 * 			b)for this we use indexof() function at every index next to the find index
		 * 			because the substring may overlap eachother 
		 * 			example this is a testtest , here test is overlapping
		 * 			
		 * 	
		 * 
		 */
		String s="this is a test to see if it works and test";
		
	//	String s="testtesttest";
		String substring="bfjawkfja";
		
		
		underscorifySubstring(s, substring);
	}

	 public static String underscorifySubstring(String str, String substring) {
		 
		
		//String s=underscorify(collapseLocations1(getLocations(str, substring)),str);
		 ArrayList<int[]>locations=getLocations(str, substring);
		ArrayList<int[]>collapse= collapseLocations2(locations);
		 underscorify2(collapse, str);
		 return "";
	 }
		public static ArrayList<int[]> getLocations(String s,String substring)
		{
			// time (o)N * (O)N+M //finding substring at each locations 
			// for different input the complexity of this function is different , refer video
			ArrayList<int[]>locations=new ArrayList<>();
			int i=0;
			while(i<s.length())
			{
				int index=s.indexOf(substring,i);
				if(index==-1)
					break;
				
				locations.add(new int[] {index,index+substring.length()});
				
				i=index+1;
				
			}
			for(int[]a:locations)
			{
				System.out.println(a[0]+" , "+a[1]);
			}
			
			return locations;
		}
		
		public static ArrayList<int[]> collapseLocations1(ArrayList<int[]>locations)
		{	
			// (my function)
			// time -(O)N
			//atmost there could be N locations 
			
			/*
			 * in this method we collapse the locations that we found from getLocations method
			 * 
			 * if the end index of previous location is less than or equal to the start
			 * index of current locations , then collapse the locations
			 *(less than means the substring overlap eachother)
			 */
			int i=0;
			while(i<locations.size())
			{
				if(i-1>=0 && locations.get(i-1)[1]>=locations.get(i)[0])
				{
					locations.get(i)[0]=locations.get(i-1)[0];
					locations.remove(i-1);
					/*
					 *  we are not increasing the counter here beacuse 
					 *  after removing the prevous locations current index automatically reduces to 
					 *  preivous index
					 */
				}
				else
					i++;
			}
			System.out.println("collapsed Locations ");
			for(int[]a:locations)
			{
				System.out.println(a[0]+" , "+a[1]);
			}
			return locations;
		}
		public static ArrayList<int[]> collapseLocations2(ArrayList<int[]>locations)
		{
			/*
			 * algo expertt function
			 */
			if(locations.size()==0)
				return locations;
			ArrayList<int[]>collapsed=new ArrayList<>();
			collapsed.add(locations.get(0));
			int []previous=collapsed.get(0);
			
			
			for(int i=1;i<locations.size();i++)
			{
				int [] current=locations.get(i);
				if(previous[1]>=current[0])
				{
					// not updating prev location beacuse it may be collapsed in future
					previous[1]=current[1];
				}
				else
				{
					collapsed.add(current);
					previous=current;
				}
			
			}
			System.out.println("collapsed 2nd function");
			for(int[]a:collapsed)
			{
				System.out.println(a[0]+" , "+a[1]);
			}
			return collapsed;
		}
		public static String underscorify2(ArrayList<int[]>collapsedLocations,String s)
		{
			// algo expert solution
		
			int locationIndex=0;
			int i=0;
			boolean InBetween=false;
			int j=0;//toggle between start and end index of location subarray
			StringBuilder sb=new StringBuilder();
			while(i<s.length() && locationIndex<collapsedLocations.size())
			{
				// if any start or end index of current location is found than append _
				if(i==collapsedLocations.get(locationIndex)[j])
				{
					sb.append("_");
					/*in starting inbetween is false but when we find the location index start
					 * we are in a particular subarray or location hence we now need to find end of that location
					 * hence we are in between of a location therefore we toggle between the inBetween boolean varaible
					 * 
					 * 
					 */
					InBetween=!InBetween;
					
					if(!InBetween)
					{	
						/*if inbetween is false , that means we ha ve come out of prevous location
						 * and we can incrase the location index counter so that we can move to next
						 * location subarray
						 * 
						 */
						locationIndex++;
						
					}
					// we toglle between start and end index 
					// j represents either 0 or 1 that means start or end index of a particular location
					j=j==1?0:1;
				}
				sb.append(s.charAt(i));
				i++;
			}
			System.out.println(locationIndex);
			//if the input string has ended and last location of substring is at the end of intput string
			if(locationIndex<collapsedLocations.size())
			{
				sb.append("_");
			}
			//if the locations index is ended and input string counter is still less than length
			// than we have still some input string yet to be appended 
			// the loop ended because the location index has reached its end
			else if(i<s.length())
			{
				sb.append(s.subSequence(i,s.length()));
			}
			
			System.out.println(sb.toString());
			return sb.toString();
		}
		public static String underscorify(ArrayList<int[]>collapsedLocations,String s)
		{
			// time - (O)N
			//atmost there could be 2N underscores 
			StringBuilder sb=new StringBuilder();
			int k=0;
			
			// we hace applied = becasue the last index can of substring can be present at the 
			//end of input String
			for(int i=0;i<=s.length();i++)
			{
				//if start index of current location matches the current index 
				// then append the _ and increases
				if(k<collapsedLocations.size() && i==collapsedLocations.get(k)[0])
				{
					sb.append("_");
					k++;
				}
				// if currnet index matches the end index of prevous k locations 
				// than append _ , prevous k beccause we have increase the k counter in previous step	
				if(k-1>=0&& i==collapsedLocations.get(k-1)[1])
				{
					sb.append("_");
					
				}
				
				if(i<s.length())
				sb.append(s.charAt(i));
				
			}
			System.out.println(sb);
			return sb.toString();
		}
	 
	
}
