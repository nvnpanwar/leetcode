// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination

class Solution {
    class Pair{
        long distance, count;
        int city;
        public Pair(long distance, int city, long count){
            this.distance = distance;
            this.city = city;
            this.count = count;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> arr= new ArrayList<ArrayList<Pair>>(n);
        long mod = 1000000007;
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<Pair>());
        }
        for(int i=0;i<roads.length; i++){
                arr.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1], 1));
                arr.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0], 1));
        }
        Pair[] dist = new Pair[n];
        Arrays.fill(dist, new Pair(Long.MAX_VALUE,0,0));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (int)a.distance - (int)b.distance);
        pq.add(new Pair(0,0,1));
        dist[0] = new Pair(0,0,1);
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            for(int i =0;i<arr.get(top.city).size();i++){
                long clcDist = top.distance + arr.get(top.city).get(i).distance;
                if( clcDist < dist[arr.get(top.city).get(i).city].distance){
                    pq.remove(dist[arr.get(top.city).get(i).city]);
                    dist[arr.get(top.city).get(i).city] = new Pair(clcDist,arr.get(top.city).get(i).city, top.count);
                    pq.add(dist[arr.get(top.city).get(i).city]);
                }
                else if(clcDist == dist[arr.get(top.city).get(i).city].distance){
                    pq.remove(dist[arr.get(top.city).get(i).city]);
                    dist[arr.get(top.city).get(i).city] = new Pair(clcDist,arr.get(top.city).get(i).city, (top.count + dist[arr.get(top.city).get(i).city].count) % mod);
                    
                    pq.add(dist[arr.get(top.city).get(i).city]);
                }
            }
        }
        return (int)dist[n-1].count;
    }
}