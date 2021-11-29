package medium;

import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals){
		if(intervals.length == 0) return new int[0][0];
		Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
		
		ArrayList<int[]> list = new ArrayList<>();
//		list.add(intervals[0]);
		int lsp = intervals[0][0];    // last interval starting point
		int lep = intervals[0][1];    // last interval ending point

		for(int i = 1; i < intervals.length; i++) {
			int sp = intervals[i][0];
			int ep = intervals[i][1];
			
			if(lep < sp) {
				// new interval is found
				int[] sublist = {lsp, lep};
				list.add(sublist);
				
				lsp = sp;
				lep = ep;
			} else if(lep < ep){
				// partially overlapping
				lep = ep;
			} else {
				// fully overlapping
				// nothing to do
			}
		}
		
		int[] sublist = {lsp,lep};
		list.add(sublist);
		return list.toArray(new int[list.size()][]);
	}
}
