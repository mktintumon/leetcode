class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        
        int n = arr.length;
        int m = arr[0].length;
        
        int minR = 0;
        int maxR = n-1;
        int minC = 0;
        int maxC = m-1;
        
        int count = 0;
        int total = n*m;
        
        while(count < total){
            
            for(int i=minC ; i<=maxC && count<total ; i++ ){
                ans.add(arr[minR][i]);
                count++;
            }
            minR++;
            
            for(int i=minR ; i<=maxR && count<total ; i++ ){
                ans.add(arr[i][maxC]);
                count++;
            }
            maxC--;
            
            for(int i=maxC ; i>=minC && count<total ; i-- ){
                ans.add(arr[maxR][i]);
                count++;
            }
            maxR--;
            
            for(int i=maxR ; i>=minR && count<total ; i-- ){
                ans.add(arr[i][minC]);
                count++;
            }
            minC++;    
        }
        
        return ans;
    }
}