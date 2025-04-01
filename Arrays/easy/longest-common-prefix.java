// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ind = 0;
        while(ind < strs[0].length()){
            for(int i=0;i<strs.length;i++){
                if(ind >= strs[i].length()){
                    return strs[0].substring(0,ind);
                }
                if(strs[i].charAt(ind) != strs[0].charAt(ind)){
                    return strs[0].substring(0,ind);
                }
            }
            ind++;
        }
        return strs[0].substring(0,ind);
    }
}