//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int n, int A[][]){
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int gap=0 ; gap<n ; gap++){
            for(int i=0 , j=gap ; j>=0 ; i++ , j--){
                ans.add(A[i][j]);
            }
        }
        
        for(int gap=1 ; gap<n ; gap++){
            for(int i=gap , j=n-1 ; i<n ; i++ , j--){
                ans.add(A[i][j]);
            }
        }
        
        return ans;
    }
}
