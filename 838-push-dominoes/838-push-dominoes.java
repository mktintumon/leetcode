class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char[] arr = dominoes.toCharArray();
        
        int prev = 0;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] == 'L'){
                if(arr[prev] == 'L'){
                    for(int j=prev+1 ; j<i ; j++){
                        arr[j] = 'L';
                    }
                }
                else if(arr[prev] == 'R'){ 
                    int low = prev + 1;
                    int high = i - 1;
                    while(low < high){
                        arr[low] = 'R';
                        arr[high] = 'L';
                        low++;
                        high--;
                    }
                }
                
                prev = i;
            }
            else if(arr[i] == 'R'){
                if(arr[prev] == 'L'){
                    // do nothing
                }
                else if(arr[prev] == 'R'){
                    for(int j=prev+1 ; j<i ; j++){
                        arr[j] = 'R';
                    }
                }
                
                prev = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<arr.length-1 ; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}