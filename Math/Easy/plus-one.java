// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        int[] ans = new int[len];
        for(int i = len-1;i>=0;i--){
            int val = carry + digits[i];
            carry = val / 10;
            ans[i] = val % 10;
        }
        if(carry > 0){
            int[] arr = new int[len+1];
            arr[0] = carry;
            for(int i=1;i<len+1;i++){
                arr[i] = ans[i-1];
            }
            return arr;
        }
        return ans;
    }
}