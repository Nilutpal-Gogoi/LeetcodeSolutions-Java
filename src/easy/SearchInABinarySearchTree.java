package easy;

public class SearchInABinarySearchTree {
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
	
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode nn = null;
        if(root.val == val){
            nn = root;
        }else if(root.val > val){
            nn = searchBST(root.left, val);
        }else{
            nn = searchBST(root.right, val);
        }
        return nn;
    }
}
