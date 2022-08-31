class Solution {
    public int partitionDisjoint(int[] nums) {
        int pi = 0;        // partition index
        int mtp = nums[0]; // max till partition
        int mtt = nums[0]; // max till travel
        
        for(int i=1 ; i<nums.length ; i++){
            mtt = Math.max(mtt , nums[i]);
            
            //Each element in left is <= every element in right.
            if(nums[i] < mtp){
                pi = i;
                mtp = mtt;
            }
        }
        
        return pi + 1; // length
    }
}