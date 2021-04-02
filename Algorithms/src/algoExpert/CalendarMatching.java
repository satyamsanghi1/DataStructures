package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

	//my solution 
	// half test cases passed
	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;


		}
	}

	public static void main(String[] args) {

		

	}
	public static List<StringMeeting> calendarMatching(
			List<StringMeeting> calendar1,
			StringMeeting dailyBounds1,
			List<StringMeeting> calendar2,
			StringMeeting dailyBounds2,
			int meetingDuration) {

		List<StringMeeting>freeTime1=findfreetime(calendar1);
		List<StringMeeting>freeTime2=findfreetime(calendar2);

		System.out.println("a "+calendar1.get(calendar1.size()-1).end);
		System.out.println("b "+dailyBounds1.end);

		considerDailyBounds(freeTime1, freeTime2, calendar1, dailyBounds1, calendar2, dailyBounds2);

		System.out.println("free1 ");
		printData(freeTime1);
		System.out.println("free2 ");
		printData(freeTime2);

		return compare(freeTime1,freeTime2,meetingDuration);
	}
	public static void considerDailyBounds(List<StringMeeting>freeTime1,
										List<StringMeeting>freeTime2,
										List<StringMeeting> calendar1,
										StringMeeting dailyBounds1,
										List<StringMeeting> calendar2,
										StringMeeting dailyBounds2){
	
		System.out.println(subtractTime(calendar1.get(calendar1.size()-1).end,dailyBounds1.end));

		//adding last daily bound time 
		if(subtractTime(dailyBounds1.end,calendar1.get(calendar1.size()-1).end)>0)
			freeTime1.add(new StringMeeting(calendar1.get(calendar1.size()-1).end,dailyBounds1.end));

		if(subtractTime(dailyBounds2.end,calendar2.get(calendar2.size()-1).end)>0)
			freeTime2.add(new StringMeeting(calendar2.get(calendar2.size()-1).end,dailyBounds2.end));

		//adding initial daily bound time
		if(subtractTime(calendar1.get(0).start,dailyBounds1.start)>0)
			freeTime1.add(0,new StringMeeting(dailyBounds1.start,calendar1.get(0).start));

		if(subtractTime(calendar2.get(0).start,dailyBounds2.start)>0)
			freeTime2.add(0,new StringMeeting(dailyBounds2.start,calendar2.get(0).start));


		
	}
	public static List<StringMeeting>compare(List<StringMeeting>a,List<StringMeeting>b
			,int meetingDuration)
	{
		int i=0;
		int j=0;

		List<StringMeeting>avail=new ArrayList<>();

		while(i<a.size() && j< b.size())
		{
			String start="";
			String end="";
			if(subtractTime(a.get(i).start,b.get(j).start)>0)
			{
				start=a.get(j).start;
			}
			else
			{
				start=b.get(i).start;
			}

			if(subtractTime(a.get(i).end,b.get(j).end)>0)
			{
				end=b.get(j).end;
			}
			else
			{
				end=a.get(i).end;
			}
			System.out.println("final "+subtractTime(start,end));
			if(subtractTime(end,start)>=meetingDuration)
				avail.add(new StringMeeting(start,end));
			i++;
			j++;
		}

		System.out.println("ans ");
		printData(avail);
		return avail;
	}
	public static List<StringMeeting> findfreetime(List<StringMeeting>list)
	{
		List<StringMeeting>free=new ArrayList<>();
		String start="";
		String end="";
		for(int i=0;i<list.size()-1;i++)
		{
			end=list.get(i).end;
			start=list.get(i+1).start;

			if(subtractTime(start,end)>0)
			{
				free.add(new StringMeeting(end,start));
			}
		}
		return free;
	}
	public static int subtractTime(String start,String end)
	{
		System.out.println("s "+start+" e "+end );
		String a[]=end.split(":");
		String b[]=start.split(":");

		int hr1=Integer.parseInt(a[0]);
		int min1=Integer.parseInt(a[1]);

		int hr2=Integer.parseInt(b[0]);
		int min2=Integer.parseInt(b[1]);

		int hr=hr2-hr1;
		int min=min2-min1;
		System.out.println("hr "+hr +" min "+min);
		int totaltime=0;
		totaltime+=hr*60;
		totaltime+=min;

		return totaltime;
	}

	public static void printData(List<StringMeeting>list)
	{
		System.out.println();
		for(StringMeeting meet:list)
		{
			System.out.print(" start "+meet.start+" end "+meet.end);
		}
		System.out.println();
	}



}
