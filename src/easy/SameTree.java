package easy;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null && q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        boolean res = true;
        res = isSameTree(p.left, q.left);
        if(res == false){
            return false;
        }
        res = isSameTree(p.right, q.right);
        return res;
    }
}
