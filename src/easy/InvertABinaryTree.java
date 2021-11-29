package easy;


public class InvertABinaryTree {
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        mirror(root);
        return root;
    }
    
    public void mirror(TreeNode root) {
        if(root.left != null){
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
        
        TreeNode temp = root.left;
        root.left= root.right;
        root.right = temp;

	}
}
