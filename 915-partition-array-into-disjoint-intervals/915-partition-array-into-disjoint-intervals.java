class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        
        //leftMax
        for(int i=0 ; i<nums.length ; i++){
            if(i == 0){
                leftMax[i] = nums[i];
            }
            else{
                leftMax[i] = Math.max(nums[i] , leftMax[i-1]);
            }
        }
        
        //rightMin --> filling reversely
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(i == nums.length-1){
                rightMin[i] = nums[i];
            }
            else{
                rightMin[i] = Math.min(nums[i] , rightMin[i+1]);
            }
        }
        
        int ans = -1;
        for(int i=0 ; i<nums.length-1 ; i++){
            if(leftMax[i] <= rightMin[i+1]){
                ans =  i+1;
                break;
            }
        }
        
        return ans;
    }
}