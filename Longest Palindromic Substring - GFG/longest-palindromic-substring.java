//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];

       String ans = "";
       int length = 0;
       for(int gap = 0 ; gap<dp[0].length ; gap++){
           for(int i=0 , j = gap ; j < dp[0].length ; i++ , j++){
               if(gap == 0){
                   dp[i][j] = true;
               }
               else if(gap == 1){
                   dp[i][j] = s.charAt(i) == s.charAt(j);
               }
               else{
                   //boolean extremeChar = (s.charAt(i) == s.charAt(j));
                   //boolean middlePart = dp[i+1][j-1];
                   dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
               }

               if(dp[i][j] == true && length < gap+1){
                    length = gap+1;
                    ans = s.substring(i , j+1);
               }
           }
       }

       return ans;
    }
}