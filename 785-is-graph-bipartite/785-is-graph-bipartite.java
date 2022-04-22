class Solution {
    public class pair{
        int v;
        int level;
        
        pair(int v , int level){
            this.v = v;
            this.level = level;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited , -1);
        
        for(int v=0 ; v<n ; v++){
            if(visited[v] == -1){
                
                Queue<pair> qu = new LinkedList<>();
                qu.add(new pair(v , 0));
                
                while(qu.size() > 0){
                    pair rem = qu.remove();
                    
                    if(visited[rem.v] != -1){
                         // check for level -> if different level means odd length cycle
                         if(rem.level != visited[rem.v]){
                            return false;
                         }
                     }
                     else{
                        visited[rem.v] = rem.level;
                     }
                    
                    for(int e : graph[rem.v]){
                        if(visited[e] == -1){
                            qu.add(new pair(e , rem.level+1));
                        }
                    }
                }
            }
        }
        
        return true;
        
    }
}