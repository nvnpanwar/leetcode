// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<num.length();i++){
            if(st.isEmpty() || st.peek() <= num.charAt(i) || k <= 0){
                st.push(num.charAt(i));
            }
            else if (k > 0){
                st.pop();
                k--;
                i--;
            }
        }
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        String s = "";
        while(!st.isEmpty()){
            char ch = st.pop();
            s = ch + "" + s;
        }
        int i =0;
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        s = s.substring(i);
        if(s == ""){
            return "0";
        }
        return s;
    }
}