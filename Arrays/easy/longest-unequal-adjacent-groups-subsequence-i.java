// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i


class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int item = groups[0];
        for(int i=1;i<words.length;i++){
            if(groups[i] != item ){
                item = groups[i];
                list.add(words[i]);
            }
        }
        return list;
    }
}