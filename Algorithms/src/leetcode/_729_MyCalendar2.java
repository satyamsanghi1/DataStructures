package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _729_MyCalendar2 {
	//brute force leetcode solution ( (O)N^2 time)
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

		List<int[]>bookings;
		public MyCalendar() {

			bookings=new ArrayList<>();
		}

		public void print()
		{
			for(int[]booking:bookings )
			{
				System.out.println(booking[0]+":"+booking[1]);
			}
		}
		public boolean book(int start, int end) {

		
			for(int []booking:bookings)
			{
				if(start<booking[1] && end>booking[0])
					return false;
			}
			bookings.add(new int [] {start,end});
			return true;
		}
	
	}
}
