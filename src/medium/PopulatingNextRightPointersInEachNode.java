package medium;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
	
	class Node{
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	// ------------ Using Two Queues -------------------------
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> main = new LinkedList<>();
        Queue<Node> helper = new LinkedList<>();
        main.add(root);
        while(main.size() > 0){
            Node rem = main.remove();
            if(rem.left != null)
                helper.add(rem.left);
            if(rem.right != null)
                helper.add(rem.right);
            if(main.size() == 0){
                Queue<Node> temp = main;
                main = helper;
                helper = temp;
                rem.next = null;
            }else{
                rem.next = main.peek();
            }       
        }
        return root;
    }
}
