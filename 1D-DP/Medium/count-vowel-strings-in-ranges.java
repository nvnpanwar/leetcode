// https://leetcode.com/problems/count-vowel-strings-in-ranges

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] dp = new int[words.length + 1];
        dp[0] = 0;
        for(int i=0;i<words.length;i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))){
                 dp[i + 1] = dp[i] + 1;
            }
            else{
                dp[i + 1] = dp[i];
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length; i++){
            ans[i] = dp[queries[i][1] + 1] - dp[queries[i][0]];
        }
        return ans;
    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}