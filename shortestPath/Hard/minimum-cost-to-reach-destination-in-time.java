// https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/

class Solution {
    class Pair {
        int node, time, cost;

        public Pair(int node, int time, int cost) {
            this.node = node;
            this.time = time;
            this.cost = cost;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        
        ArrayList<ArrayList<Pair>> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            arrayList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2], passingFees[edges[i][1]]));
            arrayList.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2], passingFees[edges[i][0]]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;
        pq.add(new Pair(0, 0 , passingFees[0]));
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            if(pair.node == n - 1) return pair.cost;
            ArrayList<Pair> curNode = arrayList.get(pair.node);
            for(int i=0;i< curNode.size();i++){
                int newTime = curNode.get(i).time + pair.time;
                if(minTime[curNode.get(i).node] > newTime && newTime <= maxTime){
                    minTime[curNode.get(i).node] = newTime;
                    pq.add(new Pair(curNode.get(i).node, newTime, passingFees[curNode.get(i).node] + pair.cost));
                }
            }
        }
        return -1;
    }
}