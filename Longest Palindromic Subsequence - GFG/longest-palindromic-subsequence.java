//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s){
        int[][] dp = new int[s.length()][s.length()];

        for(int gap=0 ; gap<dp[0].length ; gap++){
            for(int i=0 , j=gap ; j<dp[0].length ; i++ , j++){
                if(gap == 0) dp[i][j] = 1;
                else if(gap == 1){
                    // eg : ab --> if equal --> ab is longest
                    //             else ------> either a or b is longest 
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }
                else{
                    dp[i][j] = Integer.MIN_VALUE;
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1]; // 2 + middle part
                    }
                    else{
                        dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]); // niche-piche
                    }
                }
            }
        }

        return dp[0][dp[0].length-1];
    }
}