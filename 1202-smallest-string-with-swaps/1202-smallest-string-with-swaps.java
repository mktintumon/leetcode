class Solution {
    int[] parent;
    int[] rank;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        // making DSU
        for(List<Integer> pair: pairs){
            int x = pair.get(0);
            int y = pair.get(1);
            
            int x_Lead = find(x);
            int y_Lead = find(y);
            
            if(x_Lead != y_Lead){
                union(x_Lead , y_Lead);
            }
        }
        
        // making pq for lexical order
        PriorityQueue<Character>[] pq = new PriorityQueue[s.length()];
        for(int i=0 ; i<pq.length ; i++){
            pq[i] = new PriorityQueue<>();
        }
        
        // adding in pq
        for(int i=0 ; i<n ; i++){
            int i_Lead = find(i);
            char ch = s.charAt(i);
            
            pq[i_Lead].add(ch);
        }
        
        // remove from pq and form string
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            int i_Lead = find(i);
            char ch = pq[i_Lead].remove();
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    public void union(int x , int y){
        if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}