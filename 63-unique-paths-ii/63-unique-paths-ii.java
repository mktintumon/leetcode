class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1) return 0;
        
        return mazePath(n,m,grid);
    }
    
     public boolean inRange(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    
     public int mazePath(int n , int m , int[][] grid){
        int [][] dir = {{0,1}, {1,0}};
        int[][] dp = new int[n][m];
        int ans = mazePath_01(0,0,n-1,m-1,dir ,dp , grid);
        return ans;
    }
    
     public int mazePath_01(int sr, int sc, int dr, int dc, int [][] dir ,int[][] dp , int[][] grid){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
         
         if(dp[sr][sc] != 0){
             return dp[sr][sc];
         }

        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1) && grid[r][c] == 0){
                count += mazePath_01(r,c, dr, dc, dir,dp , grid);
            }
        }
        return dp[sr][sc] = count;
    }
    
}

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
        
//         if(obstacleGrid[0][0] == 1) return 0;
        
//         int[][] dp = new int[m][n];
        
//         for(int i=0 ; i<m ; i++){
//             for(int j=0 ; j<n ; j++){
//                 if(obstacleGrid[i][j] == 1){
//                     dp[i][j] = 0;
//                 }
//                 else if(i == 0 && j==0){
//                     dp[i][j] = 1;
//                 }
//                 else{
//                     int askUp = 0;
//                     int askLeft = 0;
                    
//                     if(i>0) askUp = dp[i-1][j];
//                     if(j>0) askLeft = dp[i][j-1];
                    
//                     dp[i][j] = askUp + askLeft;
//                 }
//             }
//         }
        
//         return dp[m-1][n-1];
//     }
// }