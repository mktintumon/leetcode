class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] > b[0]){
                return 1;
            } else if(a[0] == b[0]){
                return 0;
            } else {
                return -1;
            }
        });
        
        int count = 0; // set first interval 
        int end = Integer.MAX_VALUE;
        for(int[] curr : points){
            if(curr[0] > end){
                count++;
                end = curr[1];
            }
            else{
                end = Math.min(end , curr[1]);
            }
        }
        
        return count+1;
    }
}