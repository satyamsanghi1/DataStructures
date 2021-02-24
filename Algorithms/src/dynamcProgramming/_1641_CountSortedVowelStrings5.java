package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _1641_CountSortedVowelStrings5 {
	//100%Fast
//https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918507/Java-DP-O(n)-time-Easy-to-understand
	public static void main(String[] args) {


		int ans=countVowelStrings(2);
		System.out.println("ans "+ans);
	}
	public static int countVowelStrings(int n) {

		int a = 1, e = 1, i = 1, o = 1, u = 1;
		while(n > 1) {
			//look reverse from left side
			// add new char before prev string
			a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
			e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
			i = (i + o + u); // i, o, u -> ii, io, iu
			o = (o + u); // o, u -> oo, ou
			u = (u); // u -> uu
			n--;
		}

		return a + e + i + o + u;
	}

}
