//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution{
    long MOD = 1000000007;
    
    long countPS(String str){
        long[][] dp = new long[str.length()][str.length()];
        
        for(int gap=0 ; gap<dp[0].length ; gap++){
            for(int i=0 , j=gap ; j<dp[0].length ; i++ ,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }
                else if(gap == 1){
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 3 : 2;
                }
                else{
                    //formula
                    long suffix = dp[i+1][j];
                    long prefix = dp[i][j-1];
                    long middle = dp[i+1][j-1];
                    
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = (suffix + prefix + 1) % MOD;
                    }
                    else{
                        dp[i][j] = (suffix + prefix - middle + MOD) % MOD;
                    }
                }
            }
        }
        
        return dp[0][dp[0].length-1];
    }
}