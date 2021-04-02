package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _729_MyCalendar1 {
	//working 10 %fast
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

			if(bookings.size()==0){
				bookings.add(new int []{start,end-1});
				return true;
			}

			for(int i=0;i<bookings.size();i++)
			{
				int []booking=bookings.get(i);
				if(intersect(start,end-1,booking))
				{
					System.out.println("intersecting time");
					return false;
				}
				


			}
			for(int i=0;i<bookings.size();i++)
			{
				if(i>0 && start>bookings.get(i-1)[0] && start<bookings.get(i)[0] )
				{
				System.out.println("here" );	
					bookings.add(i,new int []{start,end-1});
					return true;
				}
			}
			if(bookings.get(bookings.size()-1)[0]<=start)
			{
				System.out.println("at end");
				bookings.add(new int []{start,end-1});
				return true;
			}
			if(bookings.get(0)[0]>=start)
			{
				System.out.println("at start");
				bookings.add(0,new int []{start,end-1});
				return true;
			}
			return false;
		}

		public boolean intersect(int start,int end ,int []booking)
		{
			  //prev booking
	        int start1=booking[0];
	        int end1=booking[1];
	        
	      	//if new booking start is between prev booking start and end-> start1<=start<=end1
	        
	        if(start1<=start && start<=end1)
	            return true;
	        
	        //if new booking end is between prev booking start and end -> start1<=end<=end1
	        
	        if(start1<=end && end<=end1)
	            return true;
	        
	        // if prev meeting start is between new meeting start and end -> start<=start1<=end
	        if(start<=start1 && start1<=end)
	            return true;
	        
	        // if prev meeting end is between new meeint start and end -> start<=end1<=end
	        if(start<=end1 && end1<=end)
	            return true;
	        return false;
		}
	}

		

	}
