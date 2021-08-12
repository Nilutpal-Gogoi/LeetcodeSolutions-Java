package medium;

import medium.RemoveNthNodeFromEndOfList.ListNode;

public class LinkedListCycleII {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode detectCycle(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		
    		if(slow == fast) {
    			break;
    		}
    	}
    	
    	if(fast == null || fast.next == null) return null;
    	
    	slow = head;
    	while(slow != fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	 
    	return slow;
    }
}
