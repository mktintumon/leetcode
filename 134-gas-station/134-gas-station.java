class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int totalSum = 0;
        int currSum = 0;
        
        for(int i=0 ; i<gas.length ; i++){
            totalSum += (gas[i] - cost[i]);
            currSum  += (gas[i] - cost[i]);
            
            if(currSum < 0){
                currSum = 0;
                idx = i+1;
            }
        }
        
        return totalSum >= 0 ? idx : -1;
    }
}