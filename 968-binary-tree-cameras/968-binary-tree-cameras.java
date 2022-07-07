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
    
    /*  TOTAL -> 9 CASES [C=camera , M=monitored , NM=not_monitored ]
         
         * NM - NM --> return C
         * NM - M  --> return C
         * NM - C  --> return C
         
         * C - NM  --> return C 
         # C - M   --> return M
         # C - C   --> return M
         
         * M - NM  --> return C
         $ M - M   --> return NM
         # M - C   --> return M
    */ 
    
    int count = 0;
    final int CAMERA = 1;
    final int MONITORED = 2;
    final int NOT_MONITORED = 3;
    
    public int minCameraCover(TreeNode root) {
        int val = helper(root);
        if(val == NOT_MONITORED) count++;
        return count;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return MONITORED;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left == NOT_MONITORED || right == NOT_MONITORED){
            count++;
            return CAMERA;
        }
        else if(left == CAMERA || right == CAMERA){
            return MONITORED;
        }
        else{
            return NOT_MONITORED;
        }
    }
}