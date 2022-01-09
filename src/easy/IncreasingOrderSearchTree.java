package easy;

import java.util.*;


public class IncreasingOrderSearchTree {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}
// -------------- Approach 1 --------------------
//	Here we enter all the values in arraylist in inorder manner and then create the tree
    public ArrayList<Integer> list;
    
    public void travel(TreeNode root){
       if(root == null){
            return;
        }    
        travel(root.left);
        list.add(root.val);
        travel(root.right);
    }
    
    public TreeNode increasingBST1(TreeNode root) {    
        list = new ArrayList<>();
        travel(root);
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode itr = newRoot;
        for(int i = 1; i<list.size() ; i++){
            TreeNode temp = new TreeNode(list.get(i));
            itr.right = temp;
            itr = temp;
        }
        
        return newRoot;
    }
    
//    -------------- approach 2 -------------------------
    public TreeNode curr;
    public void travelInOrder(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	travelInOrder(root.left);
        root.left = null;
    	curr.right = root;
    	curr = root;
    	travelInOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
    	TreeNode dummy = new TreeNode(-1);
    	curr = dummy;
    	travelInOrder(root);
    	return dummy.right;
    }
}
