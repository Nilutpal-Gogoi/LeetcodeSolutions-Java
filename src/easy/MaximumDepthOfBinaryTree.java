package easy;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = -1;
        height = Math.max(height, maxDepth(root.left));
        height = Math.max(height, maxDepth(root.right));
        return height+1;
    }
}
