package medium;

public class RemoveNthNodeFromEndOfList {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
		// step 1: make a forward pointer and move it by n
		ListNode frwrd = head;   // forward
		for(int i=0; i< n; i++) {
			frwrd = frwrd.next;
		}
		
		if(frwrd == null) return head.next;     // in that case n is equal to size
		
		// step 2: point head with current pointer
		ListNode curr = head;
		
		// step 3: move current and forward pointer simulatneously
		while(frwrd.next != null) {
			curr = curr.next;
			frwrd = frwrd.next;
		}
		
		// step 4: disconnect nth node using current.next
		curr.next = curr.next.next;
		return head;
    }
}
