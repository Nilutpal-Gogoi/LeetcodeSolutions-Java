package medium;

import java.util.*;

public class BinaryTreeRightSideView {
	
	class TreeNode{
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
	
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
             return new ArrayList<>();
         }
         Queue<TreeNode> main = new LinkedList<>();
         Queue<TreeNode> helper = new LinkedList<>();
         List<Integer> res = new ArrayList<>();
         main.add(root);
         while(main.size() > 0){
             TreeNode rem = main.remove();
             if(rem.left != null)
                 helper.add(rem.left);
             if(rem.right != null)
                 helper.add(rem.right);
             if(main.size() == 0){
                 Queue<TreeNode> temp = main;
                 main = helper;
                 helper = temp;
                 res.add(rem.val);
             }      
         }
         return res;
     }
}
