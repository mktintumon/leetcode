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