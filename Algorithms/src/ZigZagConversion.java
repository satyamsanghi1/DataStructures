import java.util.ArrayList;

public class ZigZagConversion {
	
	public static void main(String[] args) {
		
		String s="PAYPALISHIRING";
		int inc=0;
		int rows=4;
		
		char c[][]=new char[4][7];
		
		
		/*ArrayList<ArrayList<Character>> a=new ArrayList<>();
		
		for(int i=0;i<s.length();i++)
		{
			for(int k=0;k<rows;k++)
			{
				//System.out.println(a.get(i).get(k));
				a.get(i).add(s.charAt(inc));
				inc++;
			}
			
		}
		for(int i=0;i<a.size();i++)
		{
			for(int k=0;k<a.get(i).size();k++)
			{
				System.out.println(a.get(i).get(k));
				
			}
			
		}
		
		
		for(int i=0;i<s.length();i++)
		{
			for(int k=0;k<rows;k++)
			{
				System.out.println(a.get(i).get(k));
			}
			
		}*/
		
		for(int i=0;i<c[0].length;i++)
		{
			for(int k=0;k<c.length;k++)
			{
				System.out.println("c["+k+"]["+i+"]");
				if(i%2==0) {
				if(s.length()>inc)
				c[k][i]=s.charAt(inc);
				inc++;
				}
				else
				{
					if(k==1)
					{
						if(s.length()>inc)
							c[k][i]=s.charAt(inc);
							inc++;
					}
					else
					{
						if(s.length()>inc)
						c[k][i]='.';
					}
				}
			}
			System.out.println();
		}
		System.out.println("output");
		String x="";
		for(int i=0;i<c.length;i++)
		{
			for(int k=0;k<c[0].length;k++)
			{
				//System.out.println("c["+k+"]["+i+"]");
				
				System.out.print(" "+c[i][k]);
				if(Character.isAlphabetic(c[i][k]))
				{
					x+=c[i][k];
				}
			}
			System.out.println();
			
			
		}
		System.out.println("output final "+x);
		System.out.println(x.length());
		
		
	}

}
