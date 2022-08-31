class Solution {
    public int reachNumber(int target) {
        int n = 0;
        
        target = Math.abs(target);
        int targetNature = target % 2;
        
        while(true){
            int range = (n*(n+1))/2;
            int rangeNature = range % 2;
            
            if(target <= range){
                if(targetNature == rangeNature){
                    break;
                }
            }
            n++;
        }
        
        return n;
    }
}