// https://leetcode.com/problems/number-of-equivalent-domino-pairs

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<dominoes.length;i++){
            int[] arr = new int[2];
            arr[0] = dominoes[i][1];
            arr[1] = dominoes[i][0];
            String s1 = Arrays.toString(dominoes[i]);
            String s2 = Arrays.toString(arr);
            if(map.containsKey(s1)){
                count = count + map.get(s1);
                map.put(s1, map.get(s1) + 1);
            }
            else if(map.containsKey(s2)){
                count = count + map.get(s2);
                map.put(s2, map.get(s2) + 1);
            }
            else{
                map.put(s1, 1);
            }
        }
        return count;
    }
}