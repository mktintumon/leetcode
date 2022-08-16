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
        
        ArrayList<String> res = new ArrayList<>();
        dfs("JFK", res);
        return res;
    }
    
    public void dfs(String v, ArrayList<String> res){
        //reached destination
        if(map.containsKey(v) == false || map.get(v).size() == 0) {
            res.add(0, v);
            return;
        }

        while(map.get(v).size() > 0) {
            String newSrc = map.get(v).remove();
            dfs(newSrc, res);
        }

        res.add(0, v);
    }
}