//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution{
    int wildCard(String pat, String str){
         boolean[][] dp = new boolean[str.length()+1][pat.length()+1];
        
        int n = str.length();
        int m = pat.length();

        for(int i = n ; i>=0 ; i--){
            for(int j = m ; j>=0 ; j--){
                if(i == n && j == m){
                    dp[i][j] = true;
                }
                else if(i == n){
                    // last row
                    if(pat.charAt(j) == '*'){
                        dp[i][j] = dp[i][j+1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else if(j == m){
                    // last column
                    dp[i][j] = false;
                }
                else{
                    if(pat.charAt(j) == '?' || pat.charAt(j) == str.charAt(i)){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(pat.charAt(j) == '*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }
                    else{
                        dp[i][j] = false; // first char not matched
                    }
                }
            }
        }

        return dp[0][0] == true ? 1 : 0;
    }
}
