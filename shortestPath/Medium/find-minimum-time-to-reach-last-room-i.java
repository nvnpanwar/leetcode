// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i

class Solution {
    class Pair{
        int weight, i, j;
        public Pair(int weight, int i, int j){
            this.weight = weight;
            this.i = i;
            this.j = j;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] minTime = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minTime[0][0] = 0;
        Pair p = new Pair(0, 0, 0);
        pq.add(p);
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            int j = pair.j;
            if(pair.i < n - 1){
                if(isUpdatable(minTime[pair.i + 1][pair.j], pair.weight, moveTime[pair.i + 1][j])){
                    minTime[pair.i + 1][pair.j] = Math.max(pair.weight, moveTime[pair.i + 1][j]) + 1;
                    Pair newPair = new Pair(minTime[pair.i + 1][pair.j], pair.i + 1, pair.j);
                    pq.add(newPair);
                }
            }
            if(pair.i > 0){
                if(isUpdatable(minTime[pair.i - 1][pair.j], pair.weight, moveTime[pair.i - 1][j])){
                    minTime[pair.i - 1][pair.j] = Math.max(pair.weight, moveTime[pair.i - 1][j]) + 1;
                    Pair newPair = new Pair(minTime[pair.i - 1][pair.j], pair.i - 1, pair.j);
                    pq.add(newPair);
                }
            }
            if(pair.j > 0){
                if(isUpdatable(minTime[pair.i][pair.j  - 1], pair.weight, moveTime[pair.i][j - 1])){
                    minTime[pair.i][pair.j - 1] = Math.max(pair.weight, moveTime[pair.i][j - 1]) + 1;
                    Pair newPair = new Pair(minTime[pair.i][pair.j - 1], pair.i, pair.j - 1);
                    pq.add(newPair);
                }
            }
            if(pair.j < m - 1){
                if(isUpdatable(minTime[pair.i][pair.j  + 1], pair.weight, moveTime[pair.i][j + 1])){
                    minTime[pair.i][pair.j + 1] = Math.max(pair.weight, moveTime[pair.i][j + 1]) + 1;
                    Pair newPair = new Pair(minTime[pair.i][pair.j + 1], pair.i, pair.j + 1);
                    pq.add(newPair);
                }
            }
        }
        return minTime[n-1][m-1];
    }
    boolean isUpdatable(int currTime, int prevTime, int timeForOpen){
        return currTime > Math.max(prevTime, timeForOpen) + 1;
    }
}