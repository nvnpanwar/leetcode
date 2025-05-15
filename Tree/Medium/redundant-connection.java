// https://leetcode.com/problems/redundant-connection

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rootArr = new int[n];
        Arrays.fill(rootArr , -1);
        rootArr[edges[0][0] - 1] = edges[0][0] - 1;
        rootArr[edges[0][1] - 1] = edges[0][0] - 1;
        for(int i=1;i<n;i++){
            if(rootArr[edges[i][0] - 1] != -1 && rootArr[edges[i][1] - 1] != -1){
                int node1 = edges[i][0] - 1;
                while(rootArr[node1] != node1 ){
                    node1 = rootArr[node1];
                }
                int node2 = edges[i][1] - 1;
                while( rootArr[node2] != node2 ){
                    node2 = rootArr[node2];
                }
                if(node1 == node2){
                    return edges[i];
                }
                rootArr[node2] = node1;
            }
            else{
                if(rootArr[edges[i][0] - 1] == -1 ){
                    if(rootArr[edges[i][1] - 1] != -1){

                        rootArr[edges[i][0] - 1] = rootArr[edges[i][1] - 1];
                    }
                    else{
                        rootArr[edges[i][0] - 1] = edges[i][0] - 1;
                    }
                    
                }
                if(rootArr[edges[i][1] - 1] == -1){
                    rootArr[edges[i][1] - 1] = rootArr[edges[i][0] - 1];
                }
                
            }
        }
        return edges[0];
    }
}