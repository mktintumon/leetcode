class Solution {
    public String intToRoman(int num) {
        String[] roman = {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values =   {1000,  900, 500,  400, 100,  90,   50,  40,   10,   9,   5,    4,   1};
        
        String ans = "";
        int index = 0;
        
        while(num > 0){
            if(num - values[index] < 0){
                index++;
                continue;
            }
            else{
                ans += roman[index];
                num -= values[index];
            }
        }
        
        return ans;
        
    }
}