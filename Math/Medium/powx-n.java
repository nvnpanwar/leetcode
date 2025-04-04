// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        long pow = (long)n;
        if(pow==0){
            return 1;
        }
        if(pow<0){
            pow = -pow;
            x= 1.0/x;
        }
        double ans = 1;
        while(pow > 0){
            if(pow % 2 == 1){
                ans = ans * x;
            }
            x = x * x;
            pow = pow / 2;
        }
        return ans;
    }
}
