class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes , true);
        
        primes[0] = primes[1] = false;
        
        for(int i=2 ; i*i<=n ; i++){
            if(primes[i] == false) continue;
            
            for(int div=i ; i*div <= n ; div++){
                primes[i*div] = false;
            }
        }
        
        int count = 0;
        for(int i=2 ; i<primes.length-1 ; i++){
            if(primes[i] == true) count++;
        }
        
        return count;
    }
}