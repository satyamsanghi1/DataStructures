package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching2 {

	//my solution 
	// working (my coding based on algoexpert explanation)
	//lkeetcode solution not in eclipse convert hr and minutes to minutes
	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;


		}
	}
	static class IntegerMeeting
	{
		public Integer[]start;
		public Integer[] end;

		public IntegerMeeting(Integer[] start,Integer[] end) {
			this.start = start;
			this.end = end;
		}
		public void print()
		{
			System.out.print(start[0]+":"+start[1]+"->"+end[0]+":"+end[1]+"  ");
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
		// Write your code here.

		considerDailyBounds(calendar1,dailyBounds1);
		considerDailyBounds(calendar2,dailyBounds2);

		List<IntegerMeeting>convCal1=convertIntegerTime(calendar1);
		List<IntegerMeeting>convCal2=convertIntegerTime(calendar2);

		List<IntegerMeeting>combinedCal=merge(convCal1,convCal2);
		System.out.println();
		System.out.println("merged ");
		printCalendar(combinedCal);

		List<IntegerMeeting>flattendCal=flatten(combinedCal);
		System.out.println("flattendCal ");
		printCalendar(flattendCal);

		return findAvailableMeet(flattendCal,meetingDuration);
	}

	public static List<StringMeeting> findAvailableMeet(List<IntegerMeeting>combined,
			int meetingDuration)
	{
		List<StringMeeting>avail=new ArrayList<>();
		int i=1;
		while(i<combined.size())
		{
			if(diff(combined.get(i).start,combined.get(i-1).end)>=meetingDuration)
			{
				String start=combined.get(i-1).end[0]+":"+combined.get(i-1).end[1];
				if(combined.get(i-1).end[1]==0)
					start+="0";
				String end=combined.get(i).start[0]+":"+combined.get(i).start[1];
				if(combined.get(i).start[1]==0)
					end+="0";
				avail.add(new StringMeeting(start,end));
			}
			i++;
		}
		return avail;
	}
	public static	List<IntegerMeeting> flatten(List<IntegerMeeting>combined)
	{
		int i=1;
		List<IntegerMeeting>flattened=new ArrayList<>();
		IntegerMeeting prev=combined.get(0);
		while(i<combined.size())
		{
			IntegerMeeting curMeet=combined.get(i);

			// if curMeet is start is in range of (prvstart,prvend)
			if(compare(curMeet.start,prev.start) && compare(prev.end,curMeet.start))
			{
				if(compare(curMeet.end,prev.end))
				{
					prev=new IntegerMeeting(prev.start,curMeet.end);
				}
				else
				{
					prev=new IntegerMeeting(prev.start,prev.end);
				}
			}
			else
			{
				flattened.add(prev);
				prev=curMeet;
			}
			i++;
		}
		flattened.add(prev);
		return flattened;
	}
	public static List<IntegerMeeting> merge(List<IntegerMeeting> calendar1,List<IntegerMeeting> calendar2)
	{
		List<IntegerMeeting>combine=new ArrayList<>();
		int i=0;	//calendar 1 pointer
		int j=0;	//calendar 2 pointer

		while(i<calendar1.size() && j<calendar2.size())
		{
			calendar1.get(i).print();
			calendar2.get(j).print();
			System.out.println(compare(calendar1.get(i).start,calendar2.get(j).start));
			if(compare(calendar1.get(i).start,calendar2.get(j).start))
			{
				// if calendar1 start is bigger , add start from calendar2 
				//else add from calendar1
				combine.add(calendar2.get(j));
				j++;
			}
			else
			{
				combine.add(calendar1.get(i));
				i++;
			}
			System.out.println("-------");
		}
		return combine;
	}
	public static int diff(Integer[] time1,Integer[] time2)
	{
		int totaltime=0;
		int hr=time1[0]-time2[0];
		if(hr<0)
			return -1;

		totaltime+=hr*60;
		int min=time1[0]-time2[0];

		totaltime+=min;
		return totaltime;
	}
	public static boolean compare(Integer [] start1,Integer start2[])
	{
		//start 1 is bigger than start 2 or not 
		if(start1[0]-start2[0]>0)
		{
			//	System.out.println("here "+(start1[0]-start2[0]));
			return true;
		}
		if(start1[0]-start2[0]<0)
			return false;

		if(start1[1]-start2[1]>0)
			return true;
		if(start1[1]-start2[1]<0)
			return false;

		return true;
	}
	public static void considerDailyBounds(List<StringMeeting> calendar,StringMeeting dailyBounds)
	{
		//adding at start
		calendar.add(0,new StringMeeting("0:0",dailyBounds.start));
		//adding at end
		calendar.add(new StringMeeting(dailyBounds.end,"23:59"));
	}
	public static List<IntegerMeeting>  convertIntegerTime(List<StringMeeting> calendar)
	{                                                                                                                                                         
		List<IntegerMeeting>convCal=new ArrayList<>();

		for(StringMeeting meeting:calendar)
		{
			String start[]=meeting.start.split(":");
			String end[]=meeting.end.split(":");

			Integer start1[]=new Integer[]{Integer.parseInt(start[0]),Integer.parseInt(start[1])};
			Integer end1[]=new Integer[]{Integer.parseInt(end[0]),Integer.parseInt(end[1])};
			convCal.add(new IntegerMeeting(start1,end1));

		}
		return convCal;
	}
	public static void printCalendar(List<IntegerMeeting>cal)
	{
		System.out.println();
		for(IntegerMeeting meet:cal)
		{
			meet.print();
		}
		System.out.println();
	}
}
