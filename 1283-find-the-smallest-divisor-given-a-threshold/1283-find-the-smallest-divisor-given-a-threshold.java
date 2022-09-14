class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        //int high = max element in array
        int high = Arrays.stream(nums).max().getAsInt(); // O(n)
        
        while(low < high){
            int mid = (low + high) / 2;
            
            int sum = 0;
            for(int val : nums){
               int quotient = (val + mid - 1) / mid; 
               sum += quotient;
            }
            
            if(sum > threshold){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
}