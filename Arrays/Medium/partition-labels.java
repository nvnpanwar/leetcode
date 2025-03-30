// https://leetcode.com/problems/partition-labels/description/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int lastInd = i;
            int j = i;
            while(j < s.length()){
                if(s.charAt(j) == s.charAt(i)){
                    lastInd = j;
                }
                j++;
            }
            arr[i] = lastInd;
        }
        List<Integer> ans = new ArrayList<Integer>();
        int i=0;
        while(i<arr.length){
            int j = arr[i];
            int start = i;
            while(i<arr.length){
                if(i==j){
                    i++;
                    break;
                }
                else if(arr[i] > j){
                    j = arr[i];
                }
                i++;
            }
            ans.add(i-start);
        }
        return ans;
    }
}
//arr= [8,5,8,5,7,5,8,7,8,14,15,11,15,13,14,15,19,22,23,19,20,21,22,23]


// i=24,
// s=16
// j=23,
// ans=[9,7,8]