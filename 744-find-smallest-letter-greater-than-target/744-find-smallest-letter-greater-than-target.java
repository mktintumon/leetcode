class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        
        int ans = 0 ;
        while(left <= right){
            int mid = left + (right-left)/2;
    
            // just greater will be answer
            if(letters[mid] > target){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return letters[ans];
    }
}