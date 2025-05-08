// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii

class Solution {
    class Pair{
        int i,j,dist,time;
        public Pair(int i, int j, int dist, int time){
            this.i = i;
            this.j = j;
            this.dist = dist;
            this.time = time;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }
        arr[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist - b.dist);
        pq.add(new Pair(0,0,0,1));
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int[] forI = {0, 1, -1, 0};
            int[] forJ = {1, 0, 0, -1};
            for(int i=0;i<4;i++){
                if(
                    forJ[i] + pair.j < m && 
                    forJ[i] + pair.j >= 0 && 
                    forI[i] + pair.i < n && 
                    forI[i] + pair.i >= 0 &&
                    Math.max(pair.dist, moveTime[forI[i] + pair.i][forJ[i] + pair.j]) + pair.time < arr[forI[i] + pair.i][forJ[i] + pair.j]
                    ){
                        arr[forI[i] + pair.i][forJ[i] + pair.j] = Math.max(pair.dist, moveTime[forI[i] + pair.i][forJ[i] + pair.j]) + pair.time;
                        pq.add(new Pair(forI[i] + pair.i, forJ[i] + pair.j, arr[forI[i] + pair.i][forJ[i] + pair.j], pair.time == 1 ?2:1)); 
                }
            }

        }
        return arr[n-1][m-1];
    }
}