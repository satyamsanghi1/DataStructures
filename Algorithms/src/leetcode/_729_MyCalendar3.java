package leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

public class _729_MyCalendar3 {
	// Efficient leetcode solution ( (O)NLogN time)
	public static void main(String[] args) {

		MyCalendar calendar=new MyCalendar();

		System.out.println(calendar.book(47,50));
		System.out.println("--------------------------");
		System.out.println(calendar.book(33,41));
		System.out.println("--------------------------");
		System.out.println(calendar.book(39,45));
		System.out.println("--------------------------");
		System.out.println(calendar.book(33,42));
		System.out.println("--------------------------");
		System.out.println(calendar.book(25,32));
		System.out.println("--------------------------");
		System.out.println(calendar.book(26,35));
		System.out.println("--------------------------");
		System.out.println(calendar.book(19,25));
		System.out.println("--------------------------");
		System.out.println(calendar.book(3,8));  
		System.out.println("--------------------------");
		System.out.println(calendar.book(8,13));
		calendar.print();
		System.out.println("--------------------------");
		System.out.println(calendar.book(18,27));
		System.out.println("--------------------------");
		calendar.print();
	}


	static class MyCalendar {

		TreeMap<Integer,Integer>calendar;
		public MyCalendar() {

			calendar=new TreeMap<Integer, Integer>();
		}

		public void print()
		{
			
		}
		public boolean book(int start, int end) {
			//intervals ke beech me fit krna hai 
		Integer prevStart=calendar.floorKey(start); //start ke just pehle waala
		Integer nextStart=calendar.ceilingKey(start);	//start ke just bad wala
		
		System.out.println("prev "+prevStart+" next "+ nextStart);
		if(prevStart==null || calendar.get(prevStart)<=start && end<=nextStart)
		{
			calendar.put(start,end);
			System.out.println(calendar.toString());
			return true;
		}	
			return false;
		}
	
	}
}
