class Solution {
    public int numDecodings(String s) {
         int dp[]=new int[s.length()+1];
         Arrays.fill(dp,-1);
         return helper(s,0,dp);
    }
    
    public int helper(String s , int idx , int[] dp){
        if(s.length() == 0) return dp[idx] = 1;
        
        if(s.charAt(0) == '0') return dp[idx] = 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int count = 0;
        
        char ch1 = s.charAt(0);
        int v1 = ch1 - '0';
        String rest1 = s.substring(1);
        
         count += helper(rest1 , idx+1 , dp);
        
        if(s.length() > 1){
            int ch2 = s.charAt(1);
            int v2 = ch2 - '0';
            int num = (v1*10) + v2;
            String rest2 = s.substring(2);
            
            if(num <= 26){
                count += helper(rest2 , idx+2 , dp);
            }  
        }
        
        return dp[idx] = count;
    }
}