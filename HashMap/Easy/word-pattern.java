// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        for(int i =0;i<pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }
            else{
                map.put(pattern.charAt(i), arr[i]);
                if(set.contains(arr[i])){
                    return false;
                }
                else{
                    set.add(arr[i]);
                }
            }
        }
        return true;
    }
}