// Time: O(V+E) | Space: O(E) - E- the connection between people and judge and V - each individual

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];
        for(int[] t: trust) {
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        for(int i=0;i<n;i++) {
            if(indegrees[i] == n-1) return i+1;
        }
        return -1;
    }
}