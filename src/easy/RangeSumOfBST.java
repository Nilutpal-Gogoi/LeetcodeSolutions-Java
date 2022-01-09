package easy;

class TreeNode {
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

public class RangeSumOfBST {
    private int count;
    public int rangeSumBST(TreeNode root, int low, int high) {
        count = 0;
        range(root, low, high);
        return count;
    }
    
    private void range(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low && root.val <= high){
            count += root.val;
        }
        range(root.left, low, high);
        range(root.right, low, high);
        
        return ;
    }
}
