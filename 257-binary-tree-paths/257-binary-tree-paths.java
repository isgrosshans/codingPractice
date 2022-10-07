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
    List<String> resList = new LinkedList();
    
    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root, "");
        return resList;
    }
    
    void backtrack(TreeNode root, String resString){
        if(root.left==null && root.right==null){
            resList.add(resString+root.val);
        }
        
        if(root.left!=null){
            backtrack(root.left, resString+root.val+"->");
        }
        
        if(root.right!=null){
            backtrack(root.right, resString+root.val+"->");
        }
    }
}