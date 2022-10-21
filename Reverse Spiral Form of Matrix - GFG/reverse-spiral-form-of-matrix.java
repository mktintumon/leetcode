//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    
    public int[] reverseSpiral(int r, int c, int[][] a){
        int[] ans = new int[r*c];
        
        int minR = 0;
        int maxR = r-1;
        int minC = 0;
        int maxC = c-1;
        
        int idx = ans.length-1;
        int count = 0;
        int total = r * c;
        
        while(count < total){
            for(int i=minC ; i<=maxC && count < total ; i++){
                ans[idx] = a[minR][i];
                idx--;
                count++;
            }
            minR++;
            
            for(int i=minR ; i<=maxR && count < total; i++){
                ans[idx] = a[i][maxC];
                count++;
                idx--;
            }
            maxC--;
            
            for(int i=maxC ; i>=minC && count < total; i--){
                ans[idx] = a[maxR][i];
                count++;
                idx--;
            }
            maxR--;
            
            for(int i=maxR ; i>=minR && count < total; i--){
                ans[idx] = a[i][minC];
                count++;
                idx--;
            }
            minC++;
        }
        
        return ans;
    }
}