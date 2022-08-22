class Solution {
    public int findCenter(int[][] edges) {
        int idx = 0;
        int[] ans = new int[edges.length+2];
        Arrays.fill(ans , 0);
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            ans[u]++;
            ans[v]++;
            
            if(ans[u] > idx) idx = u;
            if(ans[v] > idx) idx = v;
        }
        
        return idx;
    }
}