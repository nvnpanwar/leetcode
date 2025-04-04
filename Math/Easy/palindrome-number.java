// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int val = 0 ;
        int temp = x ;
        while(temp > 0){
            val = val * 10 + temp % 10;
            temp = temp/10;
        }
        return val == x;
    }
}