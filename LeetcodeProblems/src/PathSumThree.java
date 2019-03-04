

/*
 * You are given a binary tree in which each node contains an integer value.

 * Find the number of paths that sum to a given value.

 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumThree {

	public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        int count = 0;
        count += pathFromNode(root,sum,0);
        count += pathSum(root.left,sum);
        count += pathSum(root.right,sum);
        return count;
    }

    public int pathFromNode(TreeNode node,int sum,int count){
        if(node==null)
            return count;
	    if(sum-node.val==0)
            count++;
        return count + pathFromNode(node.left,sum-node.val,0) + pathFromNode(node.right,sum-node.val,0);
    }
}
