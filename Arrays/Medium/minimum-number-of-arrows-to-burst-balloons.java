// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        List<Long[]> list = new ArrayList<>();
        Arrays.sort(points, (a,b)->{
            if(a[0] == b[0]){
                if(a[1] > b[1]){
                    return 1;
                }
                else if(a[1] < b[1]){
                    return -1;
                }
                else {
                    return 0;
                }
            }
            if(a[0] > b[0]){
                return 1;
            }
            else{
                return -1;
            }
        });
        for(int i=0;i<points.length;i++){
            int j=i;
            long min = points[i][1];
            while(j<points.length){
                if(points[j][0] <= min){
                    min = Math.min(min, (long)points[j][1]);
                    j++;
                }
                else{
                    break;
                }
            }
            Long[] temp = new Long[2];
            temp[0] = (long)points[i][0];
            temp[1] = min;
            list.add(temp);
            i=j-1;
        }
        return list.size();
    }
}