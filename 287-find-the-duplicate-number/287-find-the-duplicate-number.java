// class Solution {
//     public int findDuplicate(int[] nums) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
        
//         for(int i=0 ; i<nums.length ; i++){
//             if(hm.containsKey(nums[i])) return nums[i];
            
//             hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1);
//         }
        
//         return -1;
//     }
// }

class Solution {
 public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}