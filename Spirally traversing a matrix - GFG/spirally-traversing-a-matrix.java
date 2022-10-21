//{ Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c){
        ArrayList<Integer> ans = new ArrayList<>();
        
        int minR = 0;
        int maxR = r-1;
        int minC = 0;
        int maxC = c-1;
        
        int count = 0;
        int total = r * c;
        
        while(count < total){
            for(int i=minC ; i<=maxC && count < total ; i++){
                ans.add(a[minR][i]);
                count++;
            }
            minR++;
            
            for(int i=minR ; i<=maxR && count < total; i++){
                ans.add(a[i][maxC]);
                count++;
            }
            maxC--;
            
            for(int i=maxC ; i>=minC && count < total; i--){
                ans.add(a[maxR][i]);
                count++;
            }
            maxR--;
            
            for(int i=maxR ; i>=minR && count < total; i--){
                ans.add(a[i][minC]);
                count++;
            }
            minC++;
        }
        
        return ans;
    }
}
