class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> tt = new Stack<>();
        
        for(int i= 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '#'){
                if(st.size() != 0) 
                    st.pop();
                    continue;
            }
            
            st.push(ch);
        }
        
        for(int i= 0 ; i<t.length() ; i++){
            char ch = t.charAt(i);
            
            if(ch == '#'){
               if(tt.size() != 0) 
                   tt.pop();
                   continue;
            }
            
            tt.push(ch);
        }
        
        if(st.size() != tt.size()) return false;
        
        while(st.size() > 0){
            if(st.pop() != tt.pop()) return false;
        }
        
        return true;
    }
}