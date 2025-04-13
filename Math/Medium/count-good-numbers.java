// https://leetcode.com/problems/count-good-numbers

class Solution {
    public int countGoodNumbers(long n) {
        long fourPow = powx(4, n /2);
        long fivePow = powx(5, (n+1) /2);
        long mod = 1000000007;
        return (int)((fourPow * fivePow) % mod);
    }
    public long powx(long x, long n){
        if(n == 0){
            return 1;
        }
        long ans = 1;
        long mod = 1000000007;
        while(n > 0){
            if(n %2 == 1){
                ans = ans * x;
                ans = ans % mod;
            }
            x= x*x;
            x = x % mod;
            n=n/2;
        }
        return ans;
    }
}