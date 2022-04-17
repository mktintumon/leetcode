class Solution {
    
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid , int i , int j){
        // mark 
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