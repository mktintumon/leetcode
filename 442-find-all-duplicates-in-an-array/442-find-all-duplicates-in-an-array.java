class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i< nums.length ; i++){
            
             if(hm.containsKey(nums[i]) && hm.get(nums[i])  == 1){
                ans.add(nums[i]);
            }
            
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1);
        }
        
        return ans;
    }
}