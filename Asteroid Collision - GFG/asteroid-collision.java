//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i< N ; i++){
            if(st.size() == 0){
                st.push(arr[i]);
            }
            else if(arr[i] > 0){
                st.push(arr[i]);
            }
            else if(st.peek() < 0){
                st.push(arr[i]);
            }
            else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }
                
                if(st.size() == 0) st.push(arr[i]);
                else if(st.peek() == Math.abs(arr[i])) st.pop();
                else if(st.peek() < 0) st.push(arr[i]);
                else{
                    // st.peek() > Math.abs(arr[i]) 
                    // do nothing -> will destroy itself
                }
            }
        }
        
        int[] ans = new int[st.size()];
        for(int i=ans.length-1 ; i>=0 ; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}
