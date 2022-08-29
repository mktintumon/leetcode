class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int val : nums){
            min = Math.min(min , val);
        }
        
        int count = 0;
        for(int val : nums){
            count += val - min;
        }
        
        return count;
    }
}