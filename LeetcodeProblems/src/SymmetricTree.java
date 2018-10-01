

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isMirror(root,root);
    
    }
    
    public boolean isMirror(TreeNode q, TreeNode w){
        if(q==null && w==null)
            return true;
        if(q==null || w==null)
            return false;
        return q.val==w.val && isMirror(q.left,w.right) && isMirror(q.right,w.left);
    }
}

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
