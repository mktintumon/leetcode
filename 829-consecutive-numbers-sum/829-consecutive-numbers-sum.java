class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int k = 1;
        int check = (k*(k-1))/2;
        
        while(n > check){
            if((n-check) % k == 0){
                count++;
            }
            k++;
            check = (k*(k-1))/2;
        }
        
        return count;
    }
}