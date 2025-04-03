// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++){
            Map<Character, Integer> freqMap = new HashMap<>();
            for(int j = 0;j<strs[i].length();j++){
                freqMap.put(strs[i].charAt(j), freqMap.getOrDefault(strs[i].charAt(j), 0) + 1);
            }
            if(map.containsKey(freqMap)){
                List<String> val = map.get(freqMap);
                val.add(strs[i]);
                map.put(freqMap, val);
            }
            else{
                List<String> val = new ArrayList<>();
                val.add(strs[i]);
                map.put(freqMap, val);
            }
        }
        for(Map.Entry<Map<Character, Integer>, List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}