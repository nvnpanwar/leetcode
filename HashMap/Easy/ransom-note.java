// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<ransomNote.length(); i++){
            if(map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i) , map.get(ransomNote.charAt(i)) + 1);
            }
            else{
                map.put(ransomNote.charAt(i) , 1);
            }
        }
        for(int i = 0;i<magazine.length(); i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i) , map.get(magazine.charAt(i)) - 1);
                if(map.get(magazine.charAt(i)) == 0){
                    map.remove(magazine.charAt(i));
                }
            }
        }
        if(map.size() == 0){
            return true;
        }
        return false;
    }
}
