// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        Arrays.fill(arr, 0);
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         Map<Character, Integer> map = new HashMap<>();
//         if(s.length() != t.length()){
//             return false;
//         }
//         for(int i=0;i<s.length();i++){
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//             map.put(t.charAt(i), map.getOrDefault(t.charAt(i) , 0) - 1);
//         }
//         for(Map.Entry<Character, Integer> entry: map.entrySet()){
//             if(entry.getValue() != 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }