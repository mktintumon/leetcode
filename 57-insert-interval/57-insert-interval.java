class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        
        int[] interval = newInterval;
        while(i < intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(intervals[i][0] , interval[0]);
            interval[1] = Math.max(intervals[i][1] , interval[1]);
            i++;
        }
        
        ans.add(interval);
        
        while(i < intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}