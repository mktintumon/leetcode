class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int coin : coins){
            for(int tar=1 ; tar<=amount ; tar++){
                if(tar >= coin){
                    dp[tar] += dp[tar - coin];
                }
            } 
        }
        
        return dp[amount];
    }
}