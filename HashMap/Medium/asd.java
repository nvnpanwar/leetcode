// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int size = set.size();
            set.add(A[i]);
            set.add(B[i]);
            if(size == set.size()){
               count+=2;
               ans[i] = count; 
            }
            else if(size + 1 == set.size()){
                count++;
                ans[i] = count;
            }
            else{
                ans[i] = count;
            }
        }
        return ans;
    }
}