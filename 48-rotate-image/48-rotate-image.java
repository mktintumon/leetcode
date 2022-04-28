class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        for(int[] e : matrix){
            reverse1D(e);
        }
        
        for(int[] e : matrix){
            System.out.println(e);
        }
        
        
    }
    
    public static void transpose(int[][] matrix){
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=i ; j<matrix[0].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public static void reverse1D(int[] arr){
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}