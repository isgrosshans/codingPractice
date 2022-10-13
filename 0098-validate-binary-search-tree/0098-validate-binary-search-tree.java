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
    public boolean isValidBST(TreeNode root) {
        return isValidSubBST(root, null, null);
    }
    
    boolean isValidSubBST(TreeNode root, Integer upperbound, Integer lowerbound) {
        if (root == null) return true;
        
        if ((upperbound != null && root.val >= upperbound) 
            || (lowerbound != null && root.val <= lowerbound)) return false;
        
        return isValidSubBST(root.left, root.val, lowerbound)
            && isValidSubBST(root.right, upperbound, root.val);
    }
}