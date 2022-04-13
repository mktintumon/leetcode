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
    public int minDiffInBST(TreeNode root) {
        if(root==null) return 0;
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        inorderT(root,list);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i=0 ; i<list.size()-1 ; i++){
            minDiff = Math.min(minDiff,(list.get(i+1)-list.get(i)));
        }
        return minDiff;
    }
    
    private void inorderT(TreeNode root,ArrayList<Integer>list){
        if(root==null) return;
        
        inorderT(root.left,list);
        list.add(root.val);
        inorderT(root.right,list);
    }
}