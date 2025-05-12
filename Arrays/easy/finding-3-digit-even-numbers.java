// https://leetcode.com/problems/finding-3-digit-even-numbers

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=100;i<1000;i++){
            if(i%2 == 0 && isPossible(i, digits)){
                list.add(i);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    boolean isPossible(int val, int[] digits){
        boolean[] vis = new boolean[digits.length];
        Arrays.fill(vis, false);
        while(val > 0){
            boolean flag = false;
            int temp = val % 10;
            for(int i=0;i<digits.length;i++){
                if(digits[i] == temp && !vis[i]){
                    vis[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
            val = val/10;
        }
        return true;
    }
}