class Solution {
    static int[][] dir = {{-1,0}, {0,-1},{1,0}, {0,1}};
    
    public boolean exist(char[][] board, String word) {
         for(int i=0 ; i<board.length ; i++){
             for(int j=0 ; j<board[0].length ; j++){
                 if(board[i][j] == word.charAt(0) && helper(board , i , j , 0 , word)){
                     return true;
                 }
             }
         }
        
        return false;
    }
    
    private boolean helper(char[][] board, int i , int j , int idx , String word){
        if(idx == word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)){
			return false;
		}
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        
        for(int d=0 ; d<dir.length ; d++){ 
                int r = i + dir[d][0]; 
                int c = j + dir[d][1];

         boolean found =  helper(board , r, c , idx+1 , word);
         if(found == true) return true;
        }
        
        board[i][j] = temp;
        
        return false;
    }
}