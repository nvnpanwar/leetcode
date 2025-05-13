// https://leetcode.com/problems/total-characters-in-string-after-transformations-i

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] count = new int[26];
        int mod = 1000000007;
        Arrays.fill(count, 0);
        for(int i=0;i<s.length();i++){
            ++count[s.charAt(i) - 'a'];
        }
        for(int i=0;i<t;i++){
            int[] newArr = new int[26];
            newArr[0] = count[25];
            newArr[1] = (count[25] + count[0]) % mod;
            for(int j = 2;j<26;j++){
                newArr[j] = count[j-1];
            }
            count = newArr;
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            ans = (ans + count[i]) % mod;
        }
        return ans;

    }
}