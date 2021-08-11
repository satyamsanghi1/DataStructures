package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1943_DescribeThePainting {


	public static void main(String[] args) {


		int [][]segments= {{1,4,5},{4,4,7},{1,7,9}};

		splitPainting(segments);
	}
	public static List<List<Long>> splitPainting(int[][] segments) {



		List<List<Long>>list=new ArrayList<>();

		for(int i=0;i<segments.length;i++)
		{
			ArrayList<Long>l=new ArrayList<>();
			l.add((long) segments[i][0]);
			l.add((long) segments[i][1]);
			l.add((long) segments[i][2]);
			list.add(l);
		}

		Collections.sort(list,(l1,l2)->
		{
			return l1.get(0).compareTo(l2.get(0));
		}
		
				);
		System.out.println(list);

		return null;
	}
}
