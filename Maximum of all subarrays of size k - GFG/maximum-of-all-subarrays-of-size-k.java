//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution{
    static ArrayList<Integer> max_of_subarrays(int nums[], int n, int k){
        // storing idxes
        int[] nextGreater = new int[n];
        Stack<Integer> st = new Stack<>();
        nextGreater[n-1] = n; // infinite
        st.push(n-1);
        
        for(int i=n-2 ; i>=0 ; i--){
           while(st.size() > 0 && nums[i] >= nums[st.peek()]){
               st.pop();
           } 
            
           if(st.size() == 0){
               nextGreater[i] = n; // infinite
           }
           else{
               nextGreater[i] = st.peek();
           }
            
            st.push(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < n-k+1 ; i++){
            if(j < i) j = i;
            
            while(nextGreater[j] <= i + k - 1){
                j = nextGreater[j];
            }
            
            ans.add(nums[j]);
        }
        
        return ans;
    }
}