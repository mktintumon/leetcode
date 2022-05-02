class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();
        
        for(int i= 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '#'){
                if(ss.size() != 0) 
                    ss.pop();
                    continue;
            }
            
            ss.push(ch);
        }
        
        for(int i= 0 ; i<t.length() ; i++){
            char ch = t.charAt(i);
            
            if(ch == '#'){
               if(ts.size() != 0) 
                   ts.pop();
                   continue;
            }
            
            ts.push(ch);
        }
        
        if(ss.size() != ts.size()) return false;
        
        while(ss.size() > 0){
            if(ss.pop() != ts.pop()) return false;
        }
        
        return true;
    }
}