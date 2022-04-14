class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0 , nums , dp);
    }
    
    public boolean helper(int idx , int[] nums , int[] dp){
        if(idx >= nums.length-1)
            return true;
        
        if(nums[idx] == 0){
            dp[idx] = 0;
            return false;
        }
        
        if(dp[idx] != -1){
            if(dp[idx] == 0) return false;
            
            if(dp[idx] == 1) return true;
        }
        
        for(int step=1 ; step<=nums[idx] ; step++){
            if(helper(idx+step , nums , dp) == true){
                dp[idx] = 1;
                return true;
            }
        }
        
        dp[idx] = 0;
        return false;
    }
}


    
  