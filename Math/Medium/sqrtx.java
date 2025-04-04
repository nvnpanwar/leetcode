// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        if( x<=1)return x;
        long left = 0;
        long right = (long)x;
        while(left < right){
            long mid = (left + right) / 2;
            if(mid * mid > (long)x){
                right = mid;
            }
            else if(mid * mid < (long)x){
                left = mid + 1;
            }
            else{
                left = mid + 1;
                break;
            }
        }
        return (int)left - 1;
    }
}