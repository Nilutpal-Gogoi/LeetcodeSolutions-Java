package medium;

public class CopyListWithRandomPointer {
	public class Node {
	    int val;
	    Node next;
	    Node random;
	
	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyLinkedlist(Node head) {
		Node h1 = new Node(-1);
		Node temp1 = h1;
		Node temp2 = head;
		
		while(temp2 != null) {
			Node node = new Node(temp2.val);
			temp1.next = node;
			temp1 = node;
			temp2 = temp2.next;
		}
		
		return h1.next;
	}
	
	public Node copyRandomList(Node head1) {
        if(head1 == null) return null;
		// 1. Make a copy of linkedlist with next pointer only
		Node head2 = copyLinkedlist(head1);
		// 2. Make a zigzag pattern
		Node t1 = head1, t2 = head2;
		while(t1 != null && t2 != null) {
			Node n1 = t1.next;
			Node n2 = t2.next;
			
			t1.next = t2;
			t2.next = n1;
			t1 = n1;
			t2 = n2;
		}
		// 3. Make a connection of random pointer
		t1 = head1;
		while(t1 != null) {
			t1.next.random = t1.random == null ? null : t1.random.next;
			t1 = t1.next.next;
		}
		
		// 4. Regain original list
		t1 = head1;
		t2 = head2;
		
		while(t1 != null && t2 != null) {
			Node n1 = t2.next;
			Node n2 = n1 == null ? null : n1.next;
			
			t1.next = n1;
			t2.next = n2;
			t1 = n1;
			t2 = n2;
		}
		
		return head2;
	}
}
