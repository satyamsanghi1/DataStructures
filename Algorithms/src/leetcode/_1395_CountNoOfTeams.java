package leetcode;

public class _1395_CountNoOfTeams {
	
	public static void main(String[] args) {
		
		int rating[]= {1,2,3,4};
		
		numTeamsAlter(rating);
	}
	public static int numTeamsAlter(int[] rating) {
		int count=0;
		
		
	
		for(int i=0;i<rating.length;i++)
		{
		int currentInc=rating[i];
		int countInc=0;
		int countDec=0;
		int current=rating[i];
		int oldCand=0;
		int oldIncCand=0;
		for (int k=i+1;k<rating.length;k++)
		{
			// increasing conditions
			if(rating[k]>currentInc)
			{
				currentInc=rating[k];
				countInc++;
				System.out.println("increasing "+rating[k]+"global "+rating[i]);
			}
			else if(rating[k]>oldIncCand && oldIncCand!=0)
			{
				System.out.println("paird with old cand"+rating[k]+"old "+oldIncCand);
				count++;
			}
			
			 if(rating[k]<currentInc && rating[k]>rating[i])
				{
					System.out.println("marking old cand"+rating[k]);
					oldIncCand=rating[k];
				}
			if(countInc==2)
			{
				System.out.println("inc pair");
				count++;
			}
			
		
			// decreasing conditions 
			if(rating[k]<current)
			{
				current=rating[k];
				countDec++;
				System.out.println("Decreasing "+rating[k]+"global "+rating[i]);
			}
			else if(rating[k]>current && rating[k]<rating[i])
			{
				oldCand=rating[k];
				System.out.println("here in "+rating[k]);
			}
			if(countDec>=2)
			{
				System.out.println("dec pair");
				count++;
			}
			if(rating[k]<oldCand)
			{
				System.out.println("dec pair with old "+oldCand);
				count++;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("count "+count);
		System.out.println("___________________________________________");
			
		}
		
		System.out.println();
		System.out.println("answer "+count);
		
		/*for(int i=0;i<rating.length;i++)
		{
			int local=0;
			int localDec=0;
			int first=Integer.MAX_VALUE;
			int second=Integer.MAX_VALUE;
			for(int k=rating.length-1;k>i;k--)
			{
				System.out.println("current "+rating[k]);
				if(rating[k]<rating[i] && rating[k]>first)
				{
					System.out.println("decreasing "+rating[k]+"first "+first+"i "+rating[i]);
					local++;
					first=rating[k];
					
				}
				if(rating[k]>rating[i] && rating[k]<second)
				{
					
					localDec++;
					second=rating[k];
					System.out.println("increasing "+rating[k]+"second "+second+"i "+rating[i]);
					
				}
				if(localDec==2)
				{
					System.out.println("here at localDec");
				}
				
			}
			System.out.println();
			System.out.println();
			//break;
		}*/
		return count;
	}
	public static int numTeams(int[] rating) {
        
		int count=0;
		for(int i=0;i<rating.length;i++)
		{
			for(int k=i+1;k<rating.length;k++)
			{
				for(int j=k+1;j<rating.length;j++)
				{
					
					
					if(rating[i]>rating[k]&& rating [k]>rating[j])
					{
						System.out.println();
						System.out.println(rating[i]+","+rating[k]+","+rating[j]);
					}
					if(rating[i]<rating[k]&& rating [k]<rating[j])
					{
						System.out.println();
						System.out.println(rating[i]+","+rating[k]+","+rating[j]);
					}
				}
			}
		}
		
		
		return 0;
    }

}
