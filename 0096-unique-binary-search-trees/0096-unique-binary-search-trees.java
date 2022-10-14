class Solution {
    
    // using catlan
    public int numTrees(int num) {
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++){
            int left = 0;
            int right = i-1;

            while(left <= i-1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        
        return dp[num];
    }
}