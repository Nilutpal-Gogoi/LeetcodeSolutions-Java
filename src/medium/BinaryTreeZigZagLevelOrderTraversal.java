package medium;

import java.util.*;

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

public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st.push(root);
        while(st.size() != 0){
            int size = st.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                if(i%2 == 0){
                    TreeNode rem = st.pop();
                    list.add(rem.val);
                    if(rem.left!=null)
                        st2.push(rem.left);
                    if(rem.right != null)
                        st2.push(rem.right);
                }else{
                    TreeNode rem = st.pop();
                    list.add(rem.val);
                    if(rem.right != null)
                        st2.push(rem.right);
                    if(rem.left != null)
                        st2.push(rem.left);
                }
                size--;
                if(size == 0){
                    res.add(list);
                    Stack<TreeNode> temp = st;
                    st = st2;
                    st2 = temp;
                    i++;
                }
            }
        }
        return res;
    }
}
