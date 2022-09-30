class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 1;
        
        for(int i=1 ; i<arr.length ; i++){
            int max = 0;
            
            for(int j=0 ; j<i ; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max , arr[j]);
                }
            }
            
            arr[i] = max + 1;
        }
        
        int len = 0;
        for(int val : arr){
            len = Math.max(len , val);
        }
        
        return len;
    }
}