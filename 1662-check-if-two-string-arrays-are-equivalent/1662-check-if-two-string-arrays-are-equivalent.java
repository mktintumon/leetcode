class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first = "";
        String second = "";
        for(int i=0 ; i<word1.length ; i++){
            first += word1[i];
        }
        for(int i=0 ; i<word2.length ; i++){
            second += word2[i];
        }
        
        if(first.length() != second.length()) return false;
        
        for(int i=0 ; i<Math.max(first.length() , second.length()) ; i++){
            if(first.charAt(i) != second.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}