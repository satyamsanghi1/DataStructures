package algoExpert;

import java.util.LinkedHashMap;
import java.util.Map;

public class Run_LengthEncoding {

	
	public static void main(String[] args) {
		
		String s="AAAAAAAAAAAAAAAAAABBBBBBBBBCCCDDD";
			String x=	runLengthEncoding(s);
			
			System.out.println("ans "+x);
	}
	public static String runLengthEncoding(String string) {
	    
		char c=string.charAt(0);
		int count=1;
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<string.length();i++)
		{
			if(c!=string.charAt(i))
			{
				sb.append(c);
				sb.append(count);
				count=1;
				c=string.charAt(i);
			}
			else
			{
				count++;
			}
		
		}
		
    return sb.toString();
  }
}
