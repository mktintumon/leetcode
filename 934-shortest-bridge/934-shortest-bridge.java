class Solution {
    class Pair {
        int i;
        int j;
        int level;
        
        Pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        // use -1 for dfs and -2 for bfs
        
        boolean found = false;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfs(grid ,queue, i , j);
                    found = true;
                    break;
                }
            }
            //break first loop
            if(found == true){
               break;
            }   
        }
        
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(grid[rem.i][rem.j] == -2){
                continue;
            }
            
            // work
            if(grid[rem.i][rem.j] == 1){
                return rem.level - 1;
            }
            
            grid[rem.i][rem.j] = -2;
            
            
            addNeighbour(grid, queue, rem.i - 1, rem.j, rem.level + 1);
            addNeighbour(grid, queue, rem.i + 1, rem.j, rem.level + 1);
            addNeighbour(grid, queue, rem.i, rem.j - 1, rem.level + 1);
            addNeighbour(grid, queue, rem.i, rem.j + 1, rem.level + 1);
        }
        
        return -1;
    }
    
    public void addNeighbour(int[][] grid, ArrayDeque<Pair> queue, int i, int j, int level){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        } else if(grid[i][j] == -1 || grid[i][j] == -2) {
            return;
        }
        
        queue.add(new Pair(i, j, level));
    }
    
    public void dfs(int[][] grid ,ArrayDeque<Pair> queue, int i , int j){
         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1){
            return;
        }
        
        //mark and add
        grid[i][j] = -1;
        queue.add(new Pair(i , j , 0));
        
        //call 4 sides
        dfs(grid , queue , i-1 , j);
        dfs(grid , queue , i+1 , j);
        dfs(grid , queue , i , j-1);
        dfs(grid , queue , i , j+1);
    }
}