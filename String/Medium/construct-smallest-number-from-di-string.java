// https://leetcode.com/problems/construct-smallest-number-from-di-string

class Solution {
    public String smallestNumber(String pattern) {
        int start =  -1;
        String ans = "";
        int digit = 1;
        while(start < pattern.length()){
            int i = start + 1;
            String temp = "";
            while(i < pattern.length() && pattern.charAt(i) != 'I'){
                i++;
            }
            int j = i;
            while(i > start){
                temp = digit + "" + temp;
                i--;
                digit++;
            }
            start = j;
            ans += temp;

        }
        return ans;
    }
}