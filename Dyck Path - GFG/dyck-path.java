//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.dyckPaths(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long dyckPaths(int num) {
        long[] dp = new long[num+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++){
            int left = 0;
            int right = i-1;

            while(left <= i-1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        
        return dp[num];
    }
};