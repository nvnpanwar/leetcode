// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<Integer[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int j = i;
            int max = intervals[j][1];
            while(j < intervals.length - 1){
                if(max >= intervals[j+1][0]){
                    max = Math.max(max, intervals[j+1][1]);
                    j++;
                }
                else{
                    break;
                }
            }
            Integer[] ele = new Integer[2];
            ele[0] = intervals[i][0];
            ele[1] = max;
            ans.add(ele);
            i = j;
        }
        int[][] ansArr = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            int[] temp = new int[2];
            temp[0] = ans.get(i)[0];
            temp[1] = ans.get(i)[1];
            ansArr[i] = temp;
        }
        return ansArr;
    }
}