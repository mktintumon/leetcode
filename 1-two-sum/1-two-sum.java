class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0 ; i<nums.length ; i++){
            if(hm.containsKey(nums[i])){
                ans[0] = hm.get(nums[i]); 
                ans[1] = i;
                return ans;
            }
            
            hm.put(target-nums[i] , i);
        }
        
        return ans;
    }
}