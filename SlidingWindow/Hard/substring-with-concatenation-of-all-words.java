// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length();
        int i=0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int j = 0;j<words.length;j++){
            if(map2.containsKey(words[j])){
                map2.put(words[j], map2.get(words[j]) + 1);
            }
            else{
                map2.put(words[j], 1);
            }
        }
        while(i <= s.length() - (len * words.length)){
            String sub = s.substring(i, i + (len * words.length));
            if(find(map2, words, sub)){
                ans.add(i);
            }
            i = i + 1;

        }
        return ans;
    }
    public boolean find(Map<String, Integer> given, String[] words, String s){
        Map<String, Integer> map = new HashMap<>();
        int k = 0;
        int len = words[0].length();
        while( k < len * words.length){
            if(map.containsKey(s.substring(k,k+len))){
                map.put(s.substring(k,k+len), map.get(s.substring(k,k+len)) + 1);
            }
            else{
                map.put(s.substring(k,k+len), 1);
            }
            k = k +len;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(given.get(entry.getKey()) != entry.getValue()){
                return false;
            }
        }

        return true;
    }
}

// in js
// /**
//  * @param {string} s
//  * @param {string[]} words
//  * @return {number[]}
//  */
// var findSubstring = function (s, words) {
//     let windowLen = words[0].length * words.length;
//     let wordLen = words[0].length;
//     let json = {};
//     for (let i = 0; i < words.length; i++) {
//         if (json[words[i]]) {
//             json[words[i]] = json[words[i]] + 1
//         }
//         else {
//             json[words[i]] = 1;
//         }
//     }
//     let ans = [];
//     for (let i = 0; i < s.length - windowLen + 1; i++) {
//         let substring = s.substring(i, i + windowLen);
//         if (find(substring, json, wordLen)) {
//             ans.push(i);
//         }
//     }
//     return ans;

// };
// var find = function (substring, json, wordLen) {
//     let sub = {};
    
//     for (let i = 0; i < substring.length - wordLen + 1; i+=wordLen) {
//         if (sub[substring.substring(i, i + wordLen)]) {
//             sub[substring.substring(i, i + wordLen)] = sub[substring.substring(i, i + wordLen)] + 1;
//         }
//         else {
//             sub[substring.substring(i, i + wordLen)] = 1
//         }
//     }
//     // console.log(substring,json,sub)
//     for (let val in json) {
//         if(json[val] != sub[val] ){
//             return false;
//         }
//     }
//     return true;
// }