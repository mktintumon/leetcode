//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


class Sol{
    int countRev (String s){
        if(s.length() % 2 != 0){
            return -1;    
        }
        
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                st.push(ch);
            }
            else if(st.size() == 0){
                st.push(ch);
            }
            else if(st.peek() == '}'){
                st.push(ch);
            }
            else{
                st.pop();
            }
        }
        
        int openCount = 0;
        int closedCount = 0;
        while(st.size() > 0){
            if(st.peek() == '{'){
                openCount++;
            }
            else{
                closedCount++;
            }
            st.pop();
        }
        
        return (openCount+1)/2 + (closedCount+1)/2;
    }
}