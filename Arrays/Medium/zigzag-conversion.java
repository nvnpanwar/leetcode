// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        int[] arr = new int[s.length() + 2*numRows - 1];
        Arrays.fill(arr,0);
        String ans = "";
        for (int i = 0; i < arr.length; i += 2 * numRows - 3 + 1) {
            arr[i] = 1;
            if(i<s.length()){
                ans += s.charAt(i);
            }
        }
        
        while (true) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            boolean flag = false;
            for(int i=0;i<arr.length;i++){
                if(copy[i] == 1){
                    continue;
                }
                else if((i!=0 && copy[i-1] == 1) || (i != arr.length -1 && copy[i+1] == 1)){
                    arr[i] = 1;
                    if(i<s.length()){
                        ans += s.charAt(i);
                    }
                    flag = true;
                }
            }
            if(!flag){
                break; 
            }
        }
        return ans;
    }
}