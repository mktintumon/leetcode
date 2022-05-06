class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        
        int ans = 1;
        int start = 1;
        int end = x/2 + 1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(mid > x/mid) end = mid-1;
            else{
                start = start + 1;
                ans = start;
            }
        }
        
        return end;
    }
}