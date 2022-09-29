/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        
        return helper(0, root);
    }
    
    int helper(int parentVal, TreeNode node){
        if (node.left!=null && node.right!=null)        
            return helper(parentVal*10 + node.val , node.left) 
                + helper(parentVal*10 + node.val, node.right);
        
        if (node.left==null && node.right==null)
            return parentVal*10 + node.val;
        
        if (node.left != null)
            return helper(parentVal*10 + node.val , node.left);
        
        return helper(parentVal*10 + node.val, node.right);

        
    }
}