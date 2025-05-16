// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<List<String>> list = new ArrayList<>();
        int n = groups.length;
        List<String> ans = new ArrayList<>();
        for(int i= 0;i<n;i++ ){
            List<String> list2 = new ArrayList<>();
            for(int j = 0 ;j<i;j++){
                
                if(canBeAdded(words[i], words[j], groups[i], groups[j])){
                    if(list.get(j).size() > list2.size()){
                        list2 = new ArrayList<>(list.get(j));
                    }
                }
            }

            list2.add(words[i]);
            list.add(list2);
            if(list2.size() > ans.size()){
                ans = list2;
            }
        }
        
        return ans;
    }
    boolean canBeAdded(String str1, String str2, int g1, int g2){
        if(g1 == g2){
            return false;
        }
        if(str1.length() != str2.length()){
            return false;
        }
        boolean flag =false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(flag){
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}