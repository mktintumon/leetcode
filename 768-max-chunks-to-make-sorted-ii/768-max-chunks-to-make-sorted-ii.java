class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minFromRight = new int[arr.length];
        minFromRight[arr.length-1] = arr[arr.length-1];
        
        for(int i=arr.length-2 ; i>=0 ; i--){
            minFromRight[i] = Math.min(arr[i] , minFromRight[i+1]);    
        }
        
        int count = 0;
        int max = arr[0];
        
        for(int i=0 ; i<arr.length-1 ; i++){
            max = Math.max(max , arr[i]);
            if(max <= minFromRight[i+1]){
                count++;
            }
        }
        
        return count+1;
    }
}