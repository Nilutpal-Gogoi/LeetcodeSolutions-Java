package medium;

public class DeleteTheMiddleNodeOfALinkedList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
		ListNode(int val, ListNode next){
			this.val = val;
			this.next = next;
		}
		
	}
	
	public ListNode deleteMiddle(ListNode head) {
		if(head.next == null) return null;
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		
		
		prev.next = slow.next;
		return head;
	}
}
