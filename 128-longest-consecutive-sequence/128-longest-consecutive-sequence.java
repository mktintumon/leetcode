class Solution {
    public int longestConsecutive(int[] nums) {      
        Arrays.sort(nums);
        int prev = 0;
        int current = 0;
        int tempLen = 1, maxLen = 1;
        
        if (nums.length == 0){
            return 0;
        }
        
        for (int i=1 ; i<nums.length ; i++){
            current = nums[i];
            prev = nums[i-1]; 
            
            if (prev != current){
                if (prev == current-1){
                    tempLen++;
                }
                else{
                    tempLen = 1;
                 }
            }

            if (tempLen > maxLen){
                maxLen = tempLen;
            }
        }
        return maxLen;
    }
}

//          HashMap<Integer , Boolean> hm = new HashMap<>();
        
//         // put
//          for(int ele : nums){
//             hm.put(ele , true);
//          }
        
//           // finding potential starting point 
//           for(int i=0 ; i<nums.length ; i++){
//             if( hm.containsKey(nums[i]-1) ){
//                 hm.put(nums[i] , false);
//             }
//           }
        
//           int maxLen = 0;
//           int maxSrtP = 0;
//           for(int ele : nums){
//               if(hm.get(ele) == true){
//                  int tempLen = 1;
//                  int tempSrtP = ele;
              
//               while(hm.containsKey(tempLen+tempSrtP)){
//                   tempLen++;
//               }
              
//               if(tempLen > maxLen){
//                   maxLen = tempLen;
//                   maxSrtP = tempSrtP;
//               }
//              }
//           }
        
//           return maxLen;