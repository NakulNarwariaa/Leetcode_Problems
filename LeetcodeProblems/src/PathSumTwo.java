import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 */

public class PathSumTwo {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> out = new ArrayList<List<Integer>>();
	        path(root, sum, out, new ArrayList<Integer>());
	        return out;
	    }
	    
	    public void path(TreeNode root, int sum, List<List<Integer>> out, List<Integer> pathToNode){
	        
	        if(root == null)
	            return; 
	        
	        sum -= root.val;
	        pathToNode.add(pathToNode.size(),root.val);
	        
	        if(root.left ==null && root.right==null){
	            if(sum==0)
	            {
	                out.add(new ArrayList<Integer>(pathToNode));
	                pathToNode.remove(pathToNode.size()-1);
	                return;
	                
	            }
	                
	        }
	        
	        path(root.left, sum, out, pathToNode);
	        path(root.right, sum, out, pathToNode);
	        pathToNode.remove(pathToNode.size()-1);
	        
	    }
	
	

}
