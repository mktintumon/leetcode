class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer me = null;
        
        for(int val : nums){
            if(count == 0){
                me = val;
                count = 1;
            }
            else if(val == me){
                count++;
            }
            else{
                count--;
            }
        }
        
        return me;
    }
}