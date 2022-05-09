class Solution {
    
    static String[] key = { "" , "" , "abc" , "def" , "ghi" ,"jkl" ,"mno" , "pqrs" , "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        List<String> ans = new ArrayList<>();
        helper(digits , "" ,  ans);
        return ans;
    }
    
    private void helper(String digits , String path , List<String> ans){
      if(digits.length() == 0){
          ans.add(path);
          return;
      }
        
      char ch = digits.charAt(0);
      String rest = digits.substring(1);
      String code = key[ch-'0'];
        
      for(int i=0 ; i< code.length() ; i++){
          char newChar = code.charAt(i);
          helper(rest , path+newChar , ans);
      }  
    }
} 