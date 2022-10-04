class Solution {
    public int countHousePlacements(int n) {
        long mod = 1000000007;
        
        long oneWale = 1;
        long zeroWale = 1;
        
        for(int i=2 ; i<=n ; i++){
            long newZeroWale = oneWale % mod;
            long newOneWale = (zeroWale + oneWale) % mod;
            
            oneWale = newOneWale;
            zeroWale = newZeroWale;
        }
        
        long total=(oneWale+zeroWale)%mod;
        total=(total*total)%mod;

      return (int)total;
    }
}