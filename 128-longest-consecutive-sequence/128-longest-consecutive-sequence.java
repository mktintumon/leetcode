class Solution {
    public int longestConsecutive(int[] nums) {
         HashMap<Integer , Boolean> hm = new HashMap<>();
        
        // put
         for(int ele : nums){
            hm.put(ele , true);
         }
        
          // finding potential starting point 
          for(int i=0 ; i<nums.length ; i++){
            if( hm.containsKey(nums[i]-1) ){
                hm.put(nums[i] , false);
            }
          }
        
          int maxLen = 0;
          int maxSrtP = 0;
          for(int ele : nums){
              if(hm.get(ele) == true){
                 int tempLen = 1;
                 int tempSrtP = ele;
              
              while(hm.containsKey(tempLen+tempSrtP)){
                  tempLen++;
              }
              
              if(tempLen > maxLen){
                  maxLen = tempLen;
                  maxSrtP = tempSrtP;
              }
             }
          }
        
          return maxLen;
    }
}