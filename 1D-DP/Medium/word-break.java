// https://leetcode.com/problems/word-break

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        for(int i=1;i<dp.length;i++){
            for(int j = 0;j<i;j++){
                if(set.contains(s.substring(j,i))){
                    dp[i] = dp[j] || dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}