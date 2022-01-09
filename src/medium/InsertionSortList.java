package medium;

public class InsertionSortList {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if(head.next == null) {
			return head;
		}
		ListNode head1 = head;
		ListNode tail1 = head;
		ListNode temp = head.next;
		while(temp != null) {
			ListNode temp2 = head1;
			if(temp.val >= tail1.val) {
                tail1 = temp;
				temp = temp.next;
				continue;
			}else if(temp.val <= temp2.val) {
				tail1.next = temp.next;
				ListNode nn = temp;
				temp = temp.next;
				nn.next = temp2;
				head1 = nn;
				continue;
			}else {
				ListNode prev = null;
				while(temp.val > temp2.val) {
					prev = temp2;
					temp2 = temp2.next;
				}
				tail1.next = temp.next;
				ListNode nn = temp;
				temp = temp.next;
				nn.next = prev.next;
				prev.next = nn;
			}
		}
		
		return head1;
	}
	
}
