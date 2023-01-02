//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean[][] isPal;

    static void isPalindrome(String s){
        isPal = new boolean[s.length()][s.length()];

        for(int gap=0 ; gap<isPal[0].length ; gap++){
            for(int i=0 , j=gap ; j<isPal[0].length ; i++ , j++){
                if(gap == 0) isPal[i][j] = true;
                else if(gap == 1) isPal[i][j] = (s.charAt(i) == s.charAt(j));
                else{
                    isPal[i][j] = (s.charAt(i) == s.charAt(j)) && (isPal[i+1][j-1] == true);
                }
            }
        }
    }
    
    static int palindromicPartition(String s){
        if(s.length() <= 1) return 0;

        isPalindrome(s);
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt(0) == s.charAt(1) ? 0 : 1;

        for(int j=2 ; j<dp.length ; j++){
            dp[j] = j; // each cell of dp will have max j cuts

            if(isPal[0][j] == true){
                dp[j] = 0;
            }
            else{
                for(int i = j ; i> 0 ; i--){
                    if(isPal[i][j] == true){
                        dp[j] = Math.min(dp[j] , dp[i-1]  + 1);
                    }
                }
            }
        }

        return dp[dp.length-1];
    }
}