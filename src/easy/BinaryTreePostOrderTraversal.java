package easy;

import java.util.*;

public class BinaryTreePostOrderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root != null){
            postorder(root, res);   
        }
        return res;
    }
    
    public void postorder(TreeNode root, ArrayList<Integer> res){
        
        if(root.left != null) {
            postorder(root.left, res);
        }
        if(root.right != null){
            postorder(root.right, res);
        }
        res.add(root.val);
    }
}
