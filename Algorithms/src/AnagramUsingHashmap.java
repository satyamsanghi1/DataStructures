import java.util.HashMap;
import java.util.Map.Entry;

public class AnagramUsingHashmap {

	 public static void main(String[] args) {
		
		 String s1="Mother In Law";
		 
		 String s2="Hitler Woman";
		 
		 s1.replaceAll(" ","");
		s2= s2.replaceAll(" ","");
		s1= s1.replaceAll(" ","");
		
		s2=s2.toLowerCase();
		s1=s1.toLowerCase();
		
		 System.out.println(s2);
		 System.out.println(s1);
		 HashMap<Character,Integer> h1=getHashMap(s1);
		 HashMap<Character,Integer> h2=getHashMap(s2);
		 
		 if(h1.equals(h2))
		 {
			 System.out.println("True");
		 }
		 else
		 {
			 System.out.println("False");
		 }
		 
	}
	 
	 public static HashMap<Character, Integer> getHashMap(String s)
	 {
		 
		 HashMap<Character,Integer>hash=new HashMap<>();
		 
		 
		 for(int i=0;i<s.length();i++)
		 {
			 if(hash.containsKey(s.charAt(i)))
			 {
				 int count=hash.get(s.charAt(i));
				 hash.put(s.charAt(i),++count);
			 }
			 else
			 {
				 hash.put(s.charAt(i),1);
			 }
			 
		 }
		 
		 return hash;
		 
		 
		 
	 }
}
