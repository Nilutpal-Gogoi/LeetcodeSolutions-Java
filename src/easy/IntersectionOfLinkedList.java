package easy;

public class IntersectionOfLinkedList {
	public static class ListNode{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode detectCycle(ListNode head2) {
		ListNode slow = head2;
		ListNode fast = head2;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == null || fast.next == null) return null;
		
		slow = head2;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode tail = headA;
		while(tail.next != null) {
			tail = tail.next;
		}
		
		tail.next = headA;
		
		ListNode res = detectCycle(headB);
		
		tail.next = null;
		return res;
	}
   
}
