// ## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

class Solution {
    // Use an in-degree array to keep track of the trusts
    // Judge will be the one with (n-1) in-degree as everyone will trust it
    // Time O(V+E)
    // Space O(N) or O(V)
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n];
        for(int[] edge:trust){
            // update for outgoing edge
            inDegrees[edge[0]-1]--;

            // update for incoming edge
            inDegrees[edge[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(inDegrees[i]==(n-1)){
                return i+1;
            }
        }
        // no judge
        return -1;
    }
}