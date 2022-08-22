class Solution {
    int[] parent;
    int[] rank;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge : edges){
            int x = find(edge[0]);
            int y = find(edge[1]);
            
            if(x != y){
                union(x , y);
            }
        }
        
        int srcL = find(source);
        int destL = find(destination);
        
        if(srcL != destL){
            return false;
        }
        else{
            return true;
        }
    }
    
    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int s1l, int s2l) {
        if (rank[s1l] < rank[s2l]) {
            parent[s1l] = s2l;
        } else if (rank[s2l] < rank[s1l]) {
            parent[s2l] = s1l;
        } else {
            parent[s1l] = s2l;
            rank[s2l]++;
        }
    }
}