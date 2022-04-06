class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0 ; i< nums.length ; i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1);
        }
        
        int ans = nums[0];
        for(Integer key : hm.keySet()){
            if(hm.get(key) < hm.get(ans)){
                ans = key;
            }
        }
        
        return ans;
    }
}