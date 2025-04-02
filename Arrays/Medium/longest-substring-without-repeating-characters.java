// https://leetcode.com/problems/longest-substring-without-repeating-characters/description

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                while(left < i && map.containsKey(s.charAt(i))){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), 1);
                ans = Math.max(ans, i - left + 1);
            }
        }
        return ans;
    }
}
