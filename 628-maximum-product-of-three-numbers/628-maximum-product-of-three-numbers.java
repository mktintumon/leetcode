class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        if(nums.length == 3){
            return nums[0]*nums[1]*nums[2];
        }
        else{
            int option1 = nums[n-1]*nums[n-2]*nums[n-3];
            int option2 = nums[0]*nums[1]*nums[n-1]; 
            
            return Math.max(option1 , option2);
        }
    }
}