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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        qu.add(root);
        
        //normal loop
        while(qu.size() > 0){
            int levelSize = qu.size();
            
            // level size loop
            for(int i=0 ; i<levelSize ; i++){
                TreeNode rem = qu.remove();
                
                if(i==levelSize-1){
                    ans.add(rem.val);
                }
                
                if (rem.left != null) {
                    qu.add(rem.left);
                }

                if (rem.right != null) {
                    qu.add(rem.right);
                }
            }
        }
        
        return ans;
    }
}