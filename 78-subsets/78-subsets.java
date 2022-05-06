/*       RECURSIVE APPROACH

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }
    
   private void helper(int[] nums,int idx,List<Integer> curr,List<List<Integer>> ans){
       if(nums.length == idx){
           ans.add(curr);
           return;
       }
       
       // add number
       List<Integer> include = new ArrayList<>(curr);
       include.add(nums[idx]);
       helper(nums , idx+1 , include , ans);
       
       //  not adding number
       List<Integer> exclude = new ArrayList<>(curr);
       helper(nums , idx+1 , exclude , ans);
   }
}

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // empty set
        
        // looping over nums array for generating subsets
        for(int e : nums){
            int size = ans.size();
            
            for(int i=0 ; i<size ; i++){
                
                //clone the ans arraylist and generate new subset 
                List<Integer> curr = new ArrayList<>(ans.get(i));
                
                // add to current
                curr.add(e);
                
                // add to ans arraylist
                ans.add(curr);
            }
        }
        
        return ans;
    }
}

