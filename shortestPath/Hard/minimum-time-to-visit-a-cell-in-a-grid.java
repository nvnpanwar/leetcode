// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid

class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int[][] min = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        pq.add(new int[]{0, 0, 0});
        min[0][0] = 0;
        int[] forX = {0, 0, -1, 1};
        int[] forY = {-1, 1, 0, 0};
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            for(int i=0;i<4;i++){
                if(
                    forX[i] + arr[1] >= 0 
                    && forX[i] + arr[1] < n 
                    && forY[i] + arr[2] < m 
                    && forY[i] + arr[2] >= 0 
                    && arr[0] + 1 < min[forX[i] + arr[1]][forY[i] + arr[2]]
                    ){
                        if(arr[0] + 1 >= grid[forX[i] + arr[1]][forY[i] + arr[2]]){
                            min[forX[i] + arr[1]][forY[i] + arr[2]] = arr[0] + 1;
                        }
                        else{
                            int fec = ((grid[forX[i] + arr[1]][forY[i] + arr[2]] - arr[0]) / 2) * 2 + 1;
                            min[forX[i] + arr[1]][forY[i] + arr[2]] = arr[0] + fec;
                        }
                        pq.add(new int[]{min[forX[i] + arr[1]][forY[i] + arr[2]], forX[i] + arr[1], forY[i] + arr[2]});
                }
            }
        }
        return min[n-1][m-1];
    }
}