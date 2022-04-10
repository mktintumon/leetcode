class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1) return 0;
        
        int[][] dp = new int[m][n];
        
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j==0){
                    dp[i][j] = 1;
                }
                else{
                    int askUp = 0;
                    int askLeft = 0;
                    
                    if(i>0) askUp = dp[i-1][j];
                    if(j>0) askLeft = dp[i][j-1];
                    
                    dp[i][j] = askUp + askLeft;
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}