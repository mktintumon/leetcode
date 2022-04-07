class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        
        int[][] ans = new int[m][n];
        
        int i=0;
        int j=0;
        for(int a=0 ; a<original.length ; a++){
            ans[i][j] = original[a];
            j++;
            
            if(j == n){
                i++;
                j = 0;
            }
        }
        
        return ans;
    }
}