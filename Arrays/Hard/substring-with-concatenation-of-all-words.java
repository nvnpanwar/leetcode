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
            
            map = new HashMap<>(map2);
            int k = i;
            
            while( k < i + (len * words.length)){
                // System.out.println(i);
                if(map.containsKey(s.substring(k,k+len))){
                    map.put(s.substring(k,k+len), map.get(s.substring(k,k+len)) - 1);
                    if(map.get(s.substring(k,k+len)) == 0){
                        map.remove(s.substring(k,k+len));
                    }
                    k = k +len;
                }
                else{
                    break;
                }
            }
            if(map.isEmpty()){
                ans.add(i);
            }
            i = i + 1;

        }
        return ans;
    }
}
