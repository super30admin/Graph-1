// Time Complexity : O(V+E), where E is number of edges  
// Space Complexity :  O(V), where we have V number of input nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach:
//Keep track of number of incoming and outgoing edges.
//If, incoming = N-1, outgoing = 0 for a node, then it is our judge according to the condition provided in the problem.
//Check the corresponding illustration for further explanation.

class Solution {
    public int findJudge(int N, int[][] trust) {
     
        //base check
        if(trust == null || N == 0) return -1; //confirm with the interviewer
        
        //initialize two arrays
        int[] out = new int[N+1]; // N+1 to keep track of nodes starting from 1
        int[] in = new int[N+1];
        
        //fill the in and out arrays //E comes from here
        for(int[] edge: trust){
            int a = edge[0];
            int b = edge[1];
            out[a]++;
            in[b]++;
        }
            
        //look for satisfying condition //V comes from here
        for(int i=1; i<=N; i++){
            if(in[i] == N-1 && out[i] == 0){
                return i;
            }
        }
        
        return -1;
        
        
    }
}