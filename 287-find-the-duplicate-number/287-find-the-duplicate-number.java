class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0 ; i<nums.length ; i++){
            if(hm.containsKey(nums[i])) return nums[i];
            
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1);
        }
        
//         for(int i=0 ; i<nums.length ; i++){
            
//         }
        return -1;
    }
}