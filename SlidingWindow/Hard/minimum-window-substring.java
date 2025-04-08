// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[256];
        Arrays.fill(arr, 0);
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i) - 'A'] = arr[t.charAt(i) - 'A'] + 1; 
        }
        int i=0;
        int j=0;
        int[] arr2 = new int[256];
        int ans = Integer.MAX_VALUE;
        String ansStr = "";
        Arrays.fill(arr2, 0);
        while(j<s.length()){
            arr2[s.charAt(j) - 'A'] = arr2[s.charAt(j) - 'A'] + 1;
            while(isPresent(arr, arr2) && i <= j){
                arr2[s.charAt(i) -'A'] = arr2[s.charAt(i) - 'A'] - 1;
                if(ans > j - i + 1){
                    ans = j - i + 1;
                    ansStr = s.substring(i, j+1);
                }
                i++;
            }
            j++;
        }
        return ansStr;
    }
    public boolean isPresent(int[] arr, int[] arr2){
        for(int i=0;i<256;i++){
            if(arr[i] != 0 && arr[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }
}