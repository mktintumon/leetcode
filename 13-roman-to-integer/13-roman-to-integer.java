class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int num = 0;
        int prev = 0;
        
        // travel right to left direction 
        for(int i=s.length()-1 ; i>=0 ; i--){
            
            switch(s.charAt(i)){
                case 'I' : num = 1 ; break;
                case 'V' : num = 5 ; break;
                case 'X' : num = 10 ; break;
                case 'L' : num = 50 ; break;
                case 'C' : num = 100 ; break;
                case 'D' : num = 500 ; break;
                case 'M' : num = 1000 ; break;        
             }
            
            // handle 4 , 9 , 40 , 90 , 400 , 900
            if(prev > num)  ans -= num;
            
            else  ans += num;
            
            prev = num;
        }
        
        return ans;
    }
}