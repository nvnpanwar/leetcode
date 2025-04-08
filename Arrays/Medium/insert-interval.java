// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervalArr = new int[intervals.length + 1][2];
        boolean flag = false;
        if(intervals.length==0){
            newIntervalArr[0] = newInterval;
        }
        for (int i = 0; i <= intervals.length; i++) {
            if (flag) {
                newIntervalArr[i] = intervals[i-1];
            } 
            else{
                if(i == intervals.length){
                    newIntervalArr[i] = newInterval;
                }
                else{
                    newIntervalArr[i] = intervals[i];
                }
                if (i < intervals.length && intervals[i][0] > newInterval[0]) {
                    flag = true;
                    newIntervalArr[i] = newInterval;
                }
            }
            
        }
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < newIntervalArr.length; i++) {
            int j = i;
            int max = newIntervalArr[j][1];
            while (j < newIntervalArr.length - 1) {
                if (max >= newIntervalArr[j + 1][0]) {
                    max = Math.max(max, newIntervalArr[j + 1][1]);
                    j++;
                } else {
                    break;
                }
            }
            Integer[] temp = new Integer[2];
            temp[0] = newIntervalArr[i][0];
            temp[1] = max;
            list.add(temp);
            i = j;
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = new int[2];
            temp[0] = list.get(i)[0];
            temp[1] = list.get(i)[1];
            ans[i] = temp;
        }
        return ans;
    }
}