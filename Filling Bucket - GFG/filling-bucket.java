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
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fillingBucket(int N) {
        int mod = 100000000;
        int[] dp = new int[N+1];
        for(int n=0 ; n<dp.length ; n++){
            if(n == 0){
                dp[n]=1;
                continue;
            }
            int count = 0;
            if(n-1 >= 0){
                count += dp[n-1] % mod;
            }
            if(n-2 >= 0){
                count += dp[n-2] % mod;
            }
            dp[n] = count % mod;

        }  
        return dp[N] % mod;
    }
};