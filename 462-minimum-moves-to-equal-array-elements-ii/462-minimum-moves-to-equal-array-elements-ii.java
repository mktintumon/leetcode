class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        
        for(int i=0 ; i<nums.length ; i++){
            if(i != mid){
                count += Math.abs(nums[mid] - nums[i]);
            }
        }
        
        return count;
    }
}