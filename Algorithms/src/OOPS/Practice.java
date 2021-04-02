package OOPS;

import java.util.ArrayList;
import java.util.List;

public class Practice {

	
	public static void main(String[] args) {
		
		ArrayList<Integer>list=new ArrayList<>();
		
		list.add(1);
		
		List<Integer>a=(ArrayList)list.clone();
	}
}
