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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();
        
        List<TreeNode> currentLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        
        nextLevel.add(root);

        
        while(nextLevel.size()!=0){
            List<Integer> levelVals = new ArrayList<>();
            
            currentLevel.clear();
            currentLevel.addAll(nextLevel);
            nextLevel.clear();
            
            for(TreeNode node : currentLevel){
                if(node!=null){
                    levelVals.add(node.val);
                        nextLevel.add(node.left);
                        nextLevel.add(node.right);
                }
            }
                            
            if(levelVals.size()!=0){
                answer.add(levelVals);    
            }
        }
        
        return answer;
    }
}