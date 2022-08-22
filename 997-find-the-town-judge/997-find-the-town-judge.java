class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] normalPeople = new int[n + 1];
        int[] candidates = new int[n + 1];
        
        for (int[] a : trust) {
            normalPeople[a[0]]++;
            candidates[a[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
			// judge: trusted by n - 1 normal people, in normalPeople array, it should be 0.
            if (candidates[i] == n - 1 && normalPeople[i] ==0) return i; 
        }
        
        return -1;
    }
}