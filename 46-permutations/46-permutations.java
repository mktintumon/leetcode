class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(nums , 0 , ans);
        return ans;
    }
    
    private void helper(int[] nums , int idx , List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> curr = new ArrayList<>();
            // each time got permutated nums arr -> printing
            for(int e : nums) 
                curr.add(e);
            
            ans.add(curr);
            return ;
        }
        
        for(int i=idx ; i<nums.length ; i++){
            // swap for different permutation
            swap(i , idx , nums);
            
            helper(nums , idx+1 , ans);
            
            // backtracking for another permutation
            swap(i , idx , nums);
        }
    }
    
    private void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}