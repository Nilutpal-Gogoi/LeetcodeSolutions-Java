package easy;

import java.util.*;

public class BinaryTreePreorderTraversal {
	public static class TreeNode {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root != null){
            preorder(root, res);   
        }
        return res;
    }
    
    public void preorder(TreeNode root, ArrayList<Integer> res){
        
        res.add(root.val);
        if(root.left != null) {
            preorder(root.left, res);
        }
        if(root.right != null){
            preorder(root.right, res);
        }
    }
}
