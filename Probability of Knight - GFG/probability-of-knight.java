//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}

// } Driver Code Ends
class Solution{
    public double findProb(int N, int start_x, int start_y, int step){
        double[][][] dp = new double[N][N][step+1];
        dp[start_x][start_y][0] = 1; //starting prob
        
        int[][] directions = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        
        for(int move=1 ; move<=step ; move++){
            for(int i=0 ; i<dp.length ; i++){
                for(int j=0 ; j<dp[0].length ; j++){
                    for(int[] dir : directions){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        
                        if(x>=0 && y>=0 && x<N && y<N){
                            dp[x][y][move] += dp[i][j][move-1] / 8;
                        }
                    }
                }
            }
        }
        
        double prob = 0;
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                 prob += dp[i][j][step];
            }
        }
        
        return prob;
        
    }
}