//time complexity: O(v+e), number of edges and nodes
//space complexity :O(v+e), indegrees and outdegrees recoridng
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null || trust.length == 0)return -1;
        
        int[]indegrees = new int[N+1];
        int[]outdegrees = new int[N+1];
        
        //record the outgoing and incoming of each node
        // u -> v 
        // 
        for(int []relation : trust){
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++;
        }
        
        //if any node has no outgoing edges and has n-1 incoming edhe then that is the judge
        for(int i = 1; i <= N;i++){
            if(outdegrees[i] == 0 && indegrees[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}