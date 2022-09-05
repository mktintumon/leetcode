class Solution {
    long MOD = 1000000007L;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        
        long ans = 0;
        long mul = 1;
        int j = nums.length-1;   
        
        for(int i=0 ; i<nums.length ; i++){
            ans = (ans + mul*nums[i] - mul*nums[j]) % MOD;
            mul = (2 * mul) % MOD;
            j--;
        }  
        
        return (int)ans;
    }
}