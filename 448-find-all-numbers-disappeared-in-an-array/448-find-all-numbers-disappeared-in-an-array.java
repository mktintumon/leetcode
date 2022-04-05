class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++){
            hm.put(nums[i] , 1);
        }
        
        for(int i=1 ; i<=n ; i++){
            boolean check = hm.containsKey(i);
            if(check == false){
               ans.add(i);
            }
        }
        
        return ans;
    }
}