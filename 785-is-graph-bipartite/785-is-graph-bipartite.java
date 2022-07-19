class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int v=0 ; v<graph.length ; v++){
            if(visited[v] == 0){
                //dfs call
                boolean isBip = dfs(graph , visited , v , 1); // 1--->color
                if(isBip == false){
                    return false;
                }    
            }
        }
        return true;
    }
    
    public boolean dfs(int[][] graph , int[] visited , int v , int color){
        visited[v] = color;
        
        for(int nbr : graph[v]){
            if(visited[nbr] == 0){
                boolean ans = dfs(graph , visited , nbr , color*(-1));
                if(ans == false){
                    return false;
                }
            }
            else{
                int presentColor = visited[nbr];
                int desiredColor = color*(-1);
                
                if(presentColor != desiredColor){
                    return false;
                }
            }
        }
        return true;
    }
}