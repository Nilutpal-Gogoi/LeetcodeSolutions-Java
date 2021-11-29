package medium;

import java.util.*;

public class FindKClosestElements {
	
	// Approach 1 with priority queue- T.C  O(nLogk)
    public static class Pair implements Comparable<Pair>{
    	int val;
    	int gap;
    	
    	public Pair(int val, int gap) {
    		this.val = val;
    		this.gap = gap;
    	}
    	
    	public int compareTo(Pair o) {
    		if(this.gap == o.gap) {
    			return this.val - o.val;
    		} else {
    			return this.gap-o.gap;
    		}
    	}
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
    	PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
    	
    	for(int i = 0; i<arr.length; i++) {
    		if(pq.size() < k) {
    			pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
    		} else {
    			if(pq.peek().gap > Math.abs(arr[i]-x)) {
    				pq.remove();
    				pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
    			}
    		}
    	}
    	
    	while(pq.size() > 0) {
    		Pair rem = pq.remove();
    		res.add(rem.val);
    	}
    	
    	Collections.sort(res);
    	
    	return res;
    }

    // Optimized Approach
    public static ArrayList<Integer> findClosest1(int[] arr, int k,int x){
    	ArrayList<Integer> res = new ArrayList<>();
    	int lo = 0;
    	int hi = arr.length-1;
    	
    	int mid = 0;
    	while(lo <= hi) {
    		mid = lo + (hi-lo)/2;
    		if(arr[mid] == x) {
    			break;
    		}else if(arr[mid] < x) {
    			lo = mid+1;
    		} else {
    			hi = mid-1;
    		}
    	}
    	
    	int i = 0;
    	int j = 0;
        if(mid>=1) {
            i = mid-1;
            j = mid;
        } else {
            i = mid;
            j = mid+1;
        }
    	
    	while(i>=0 && j<arr.length && k > 0) {
    		if(Math.abs(arr[i]-x) <= Math.abs(arr[j]-x)) {
    			res.add(arr[i]);
    			i--;
    		}else {
    			res.add(arr[j]);
    			j++;
    		}
    		k--;
    	}
    	
    	while(k > 0 && i >= 0) {
    		res.add(arr[i]);
    		k--;
    		i--;
    	}
    	
    	while(k>0 && j<arr.length) {
    		res.add(arr[j]);
    		k--;
    		j++;
    	}
    	
    	Collections.sort(res);
    	return res;
    }
}
