//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    static long trappingWater(int arr[], int n) { 
        int[] left = new int[n];
        for(int i=0 ; i<n ; i++){
            if(i == 0) left[i] = arr[i];
            else{
                left[i] = Math.max(arr[i],left[i-1]);
            }
        }
        
        int[] right = new int[n];
        for(int i=n-1 ; i>=0 ; i--){
            if(i == n-1) right[i] = arr[i];
            else{
                right[i] = Math.max(arr[i],right[i+1]);
            }
        }
        
        long water = 0;
        for(int i=0 ; i<n ; i++){
            int diff = Math.min(left[i] , right[i]);
            water += diff - arr[i];
        }
        
        return water;
     } 
}


