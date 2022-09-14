class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        
        int countZero = 0;
        int ans = 0;
        
        // i ko hmesha aage badhate jayenge
        while(i < nums.length){
            if(nums[i] == 0) countZero++;
            
            // count of zero ko control me rakhenge --> k times zero
            while(countZero > k){
                if(nums[j] == 0){
                    countZero--;
                }
                j++;
            }
            
            int length = i - j + 1;
            ans = Math.max(ans , length);
            i++;
        }
        
        return ans;
    }
}