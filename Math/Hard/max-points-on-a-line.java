// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        for(int i=0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
            for(int j = i +1; j < points.length;j++){
                double slop = 0;
                if(points[i][0] - points[j][0] != 0){
                    slop = (double)(points[i][1] - points[j][1]) / (double)(points[i][0] - points[j][0]);
                    if(slop == -(double)0){
                        slop = 0;
                    }
                }
                else{
                    slop = Double.POSITIVE_INFINITY;
                }
                map.put(slop, map.getOrDefault(slop, 0) + 1);
                ans = Math.max(ans, map.get(slop));
            }
        }
        return ans + 1;
    }
}