//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends

class Solution{
    
    static void swap(int[] arr , int x , int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    static List<Integer> nextPermutation(int n, int nums[]){
        int i = nums.length-1;
        while(i > 0){
            if(nums[i-1] >= nums[i]) i--;
            else break;
        }
        
        if(i == 0){
            Arrays.sort(nums);
            List<Integer> ans = new ArrayList<>();
            for(int x:nums){
                ans.add(x);
            }
            
            return ans;
        }
        
        int num1 = i - 1;
        
        int j = nums.length-1;
        while(j > num1){
            if(nums[j] > nums[num1]) break;
            
            j--;
        }
        
        int num2 = j;
        
        swap(nums, num1 , num2);
        
        int left = num1 + 1;
        int right = nums.length-1;
        while(left < right){
            swap(nums , left , right);
            left++;
            right--;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int x:nums){
            ans.add(x);
        }
        
        return ans;
    } 
}