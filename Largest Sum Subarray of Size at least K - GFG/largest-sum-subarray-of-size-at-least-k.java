//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends

class Compute {
    public long maxSumWithK(long a[], long n, long k){
        long[] res = new long[a.length];
        
        // kadane -> largest sum at each element
        long currSum = a[0];
        res[0] = currSum;
        for(int i=1 ; i<a.length ; i++){
            if(currSum > 0){
                currSum += a[i];
            }
            else{
                currSum = a[i];
            }
            
            res[i] = currSum;
        }
        
        // setting window --> seed first cell of window
        long[] window = new long[(int)n-(int)k+1];
        for(int i=0 ; i<k ; i++){
            window[0] = window[0] + a[i]; 
        }
        
        // filling window
        for(int i=1 ; i<window.length ; i++){
            window[i] = window[i-1] - a[i-1] + a[i+(int)k-1];
        }
        
        // inside Math.max will manage sum -> not to reduce more than required
        long ans = window[0];
        for(int i=0 ; i<window.length-1 ; i++){
            ans = Math.max(ans , Math.max(window[i+1] , window[i+1]+res[i]));
        }
        
        return ans;
    }
}