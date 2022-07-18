class Solution {
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}}; 
    
    // we can approach by the boolean visited also
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for(int i=0 ; i<n ; i++){
          for(int j=0 ; j<m ; j++){
              if(grid[i][j] == '1'){
                  dfs(grid , i , j);
                  count++;
              }
          }
        }
        return count;
    }
    
    public static void dfs(char[][] grid , int i , int j){
        grid[i][j] = '0';
        
        for(int d=0 ; d<dir.length ; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1'){
                dfs(grid , r , c);
            }
        }
    }
}