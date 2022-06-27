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
    class Pair implements Comparable<Pair>{
         TreeNode node;
         int v ; // width(|||||)
         int h ; //depth(------)
        
         Pair(TreeNode node , int v , int h){
             this.node = node;
             this.v = v;
             this.h = h;
         }
        
        // (this - other) means increasing sorting
        // (other - this) means decreasing sorting
        public int compareTo(Pair other){
            if(this.h == other.h){
                return this.node.val - other.node.val;
            }
            else{
                return this.h - other.h;
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Queue<Pair> qu = new LinkedList<>();
       HashMap<Integer , ArrayList<Pair>> map = new HashMap<>();
        
       //seeding 
       qu.add(new Pair(root , 0 , 1)); 
        
       int leftMost = 0;
       int rightMost = 0;
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            // updating range for printing
            if(rem.v < leftMost) leftMost = rem.v;
            if(rem.v > rightMost) rightMost = rem.v;
            
            if(map.containsKey(rem.v) == false){
                //create arraylist and put 
                map.put(rem.v, new ArrayList<>());
                map.get(rem.v).add(rem);
            }
            else{
                //get required key and add the node as value
                map.get(rem.v).add(rem);
            }
            
            if(rem.node.left != null){
              qu.add(new Pair(rem.node.left , rem.v - 1 , rem.h + 1));
            }
            
            if(rem.node.right != null){
              qu.add(new Pair(rem.node.right , rem.v + 1 , rem.h + 1));
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=leftMost ; i<=rightMost ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(i);
            Collections.sort(unsortedList);
            
            for(Pair temp : unsortedList){
                list.add(temp.node.val);
            }
            
            ans.add(list);
        }
         return ans;
    }
}