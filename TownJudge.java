// Time Complexity : O(E) number of edges of the graph
// Space Complexity : O(n) number of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// If we go through the question, we understand through the trust relations it is a graph.
// take an array for calculating respective trust relations for each one.
// Reduce 1 for each outgoing edge an add 1 for each incoming edge to an individual.
// We need to find the person with N-1 incoming edges after reducing all outgoing and adding all incoming edges.
// If not found return -1.

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] incoming = new int[N+1];
        for(int[] arr : trust) {
            incoming[arr[0]]--;
            incoming[arr[1]]++;
        }

        for(int i = 1; i<=N; i++) {
            if(incoming[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}