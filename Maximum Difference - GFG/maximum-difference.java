//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution{
    
    int findMaxDiff(int a[], int n){
	    int[] left = nsol(a);
	    int[] right = nsor(a);
	    
	    int diff = 0;
	    for(int i=0 ; i<a.length ; i++){
	        diff = Math.max(diff , Math.abs(left[i] - right[i]));
	    }
	    return diff;
    }
    
    int[] nsor(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0 ; i<arr.length ; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
    
    int[] nsol(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2 ; i>= 0 ; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                 ans[st.peek()] = arr[i];
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
}