class Solution {
    public double myPow(double x, int n) {
        if(n == -1) return 1/x;
        if(n == 0) return 1;
           
        double recAns = myPow(x , n/2);
        
        // for even  -> pow(2,n) = pow(2,n/2) * pow(2,n/2)
        // for odd   -> pow(2,n) = pow(2,n/2) * pow(2,n/2) * 2
        
        if(n % 2 == 0) return recAns*recAns;
        
        if(n < 0) return recAns*recAns*1/x;
        
        return recAns * recAns * x;      
    }
}