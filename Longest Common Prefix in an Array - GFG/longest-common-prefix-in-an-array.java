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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        int j = 0;
    
         while(j < arr[0].length())
         {
         char ch = arr[0].charAt(j);
         for(int i = 1 ; i < n ; i++)
         {
             if(j < arr[i].length() && arr[i].charAt(j) == ch ) 
             {
                continue;
             }
             else 
             {
                 if(j == 0) return "-1";
                 return arr[i].substring(0,j);
             }
             
         }
         j++;
     }
     
     return arr[0].substring(0,j);
    
    }
}