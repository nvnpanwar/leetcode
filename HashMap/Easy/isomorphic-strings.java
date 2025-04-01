// https://leetcode.com/problems/isomorphic-strings/description

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> hm=new HashMap<>();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                if(t.charAt(i)!=hm.get(s.charAt(i)))return false;
            }
            else{
                if(hs.contains(t.charAt(i)))return false;
                hs.add(t.charAt(i));
                hm.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}