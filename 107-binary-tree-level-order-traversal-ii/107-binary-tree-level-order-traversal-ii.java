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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        qu.add(root);
        qu.add(null); 
        
         if (root == null) {
            return ans;
        }
        
        while(qu.size() > 0){
            TreeNode rem = qu.remove();
            
            if(rem != null){
                curr.add(rem.val);
                
                if(rem.left != null){
                    qu.add(rem.left);
                }
                
                if(rem.right != null){
                    qu.add(rem.right);
                }
            }
            else{
                if(qu.size() > 0){
                    qu.add(null);
                }
                
                st.push(curr);
                curr = new ArrayList<>();
            }
            
        }
        
        while(st.size() > 0){
           curr = st.pop();
           ans.add(curr); 
        }
        
        return ans;
    }
}