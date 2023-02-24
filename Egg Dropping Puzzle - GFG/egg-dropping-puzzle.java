//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution {
    static int eggDrop(int n, int k) {
	     // k = eggs and n = floors
        int[][] dp = new int[n+1][k+1];

        //first row = XX
        //first column = 0;
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=k ; j++){
                if(j == 1){
                    dp[i][j] = 1;
                }
                else if(i == 1){
                    dp[i][j] = j;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k1=j-1 , k2=0 ; k1>=0 ; k1--,k2++){
                        int x = dp[i][k1];
                        int y = dp[i-1][k2];
                        int val = Math.max(x , y);
                        min = Math.min(min , val);
                    }

                    dp[i][j] = min+1;
                }
            }
        }

        return dp[n][k];
	}
}