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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      max = Integer.MIN_VALUE; 
      helper(root);
      return max;  
    }
    
    // return root to node sum
    // but calculate node to node sum
    public int helper(TreeNode root){
      if(root == null) return 0;
        
      int left = helper(root.left);
      int right = helper(root.right);
        
      int left_dash = Math.max(0 , left);
      int right_dash = Math.max(0 , right);
        
      // pair -> left + right + node  
      int pairSum = left_dash + right_dash + root.val; 
      if(pairSum > max){
          max = pairSum;
      }  
      
      return Math.max(left_dash, right_dash) + root.val;
    }
}