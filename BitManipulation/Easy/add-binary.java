// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int carry = 0;
        int i=a.length() - 1;
        int j=b.length() - 1;
        while(i>=0 || j>=0){
            int val = carry;
            if(i>=0 && j>=0){
                val = val + (a.charAt(i) - '0')  + (b.charAt(j) - '0');
                i--;
                j--;
            }
            else if(i>=0){
                val = val + a.charAt(i) - '0';
                i--;
            }
            else{
                val = val + b.charAt(j) - '0';
                j--;
            }
            carry = val / 2;
            val = val % 2;
            ans = val+"" + ans;
        }
        if(carry != 0){
            ans = "1" + ans;
        }
        return ans;
    }
}