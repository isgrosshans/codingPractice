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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int depth=0;
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        nextLevel.add(root);
        
        while(!nextLevel.isEmpty()){
            depth++;
            currLevel.clear();
            currLevel.addAll(nextLevel);
            nextLevel.clear();
            
            
            for(TreeNode node : currLevel){
                if(node!=null){
                    if(node.left==null && node.right==null){ return depth; }
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
        }
        return depth;
    }
}