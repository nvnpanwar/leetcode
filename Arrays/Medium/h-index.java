// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i =0;i<citations.length;i++){
            if(citations.length - i <= citations[i]){
                max = Math.max(max,citations.length - i);
            }
        }
        return max;
    }
}