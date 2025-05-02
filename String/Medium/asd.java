// https://leetcode.com/problems/push-dominoes

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(count > 0){
                count++;
                if(dominoes.charAt(i) == 'R'){
                    count = 1;
                }
                else if(dominoes.charAt(i) == 'L'){
                    count = 0;
                }
            }
            else if(dominoes.charAt(i) == 'R'){
                count++;
            }
            right[i] = count;
        }
        count = 0;
        for(int i=n-1;i>=0;i--){
            if(count > 0){
                count++;
                if(dominoes.charAt(i) == 'L'){
                    count = 1;
                }
                else if(dominoes.charAt(i) == 'R'){
                    count = 0;
                }
            }
            else if(dominoes.charAt(i) == 'L'){
                count++;
            }
            left[i] = count;
        }
        String ans = "";
        for(int i = 0;i<n;i++){
            if(left[i] == 0 && right[i] > 0){
                ans = ans + "R";
            }
            else if(left[i] > 0 && right[i] == 0){
                ans = ans + "L";
            }
            else{
                if(left[i]>right[i]){
                    ans = ans + "R";
                }
                else if(left[i]<right[i]){
                    ans = ans + "L";
                }
                else{
                    ans = ans + ".";
                }
            }
        }
        return ans;

    }
}