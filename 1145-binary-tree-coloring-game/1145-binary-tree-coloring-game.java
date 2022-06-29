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
    static int leftSize = 0;
    static int rightSize = 0;
    public static int size(TreeNode root , int x){
        if(root == null) return 0;
        
        int left = size(root.left , x);
        int right = size(root.right , x);
        
        if(root.val == x){
            leftSize = left;
            rightSize = right;
        }
        
        int total = left + right + 1;
        return total;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int totalSize = size(root , x);
        int otherSize = totalSize - (leftSize + rightSize + 1);
        
        int maxSize = Math.max(otherSize , Math.max(leftSize , rightSize));
         
        if(maxSize > totalSize/2){
            return true;
        }
        else{
            return false;
        }
    }
}