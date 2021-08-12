package hard;

import java.util.*;

public class MergeKSortedLists {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	public class pair implements Comparable<pair>{
		ListNode node;
		
		public pair(ListNode node) {
			this.node = node;
		}
		
		public int compareTo(pair o) {
			return this.node.val - o.node.val;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		PriorityQueue<pair> pq = new PriorityQueue<>();
		
		for(int i=0; i < lists.length; i++) {
			if(lists[i] != null) {
				pq.add(new pair(lists[i]));				
			}
		}
		
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		
		while(pq.size() > 0) {
			pair rem = pq.remove();
			temp.next = rem.node;
			temp = temp.next;
			
			if(rem.node.next != null) {
				pq.add(new pair(rem.node.next));
			}
		}
		
		return head.next;
	}
}
