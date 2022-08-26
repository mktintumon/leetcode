class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1;
        int end = -1;
        
        int count = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] >= left && nums[i] <= right){
                end = i;
            }
            else if(nums[i] > right){
                start = end = i;
            }
            
            // nums[i] < left ---> do nothing just proceed and add difference
            
            count += (end - start);
        }
        
        return count;
    }
}