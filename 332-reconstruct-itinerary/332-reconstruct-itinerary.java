class Solution {
    HashMap<String, PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        
        for (List<String> t : tickets) {
            String src = t.get(0);
            String dest = t.get(1);

            if (map.containsKey(src) == true) {
                map.get(src).add(dest);
            } else {
                // not present
                map.put(src, new PriorityQueue<>());
                map.get(src).add(dest);
            }
        }
        
        List<String> ans = new ArrayList<>();
        dfs("JFK", ans);
        return ans;
    }
    
    public void dfs(String v, List<String> ans){
        while(map.containsKey(v) == true && map.get(v).size() > 0){
            String nbr = map.get(v).remove();
            dfs(nbr, ans);
        }
        ans.add(0, v);
    }
}