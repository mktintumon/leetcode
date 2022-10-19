//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int majorityElement(int a[], int size){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val : a){
            hm.put(val , hm.getOrDefault(val , 0) + 1);
        }
        
        for(int val : a){
            if(hm.get(val) > size/2){
                return val;
            }
        }
        
        return -1;
    }
}