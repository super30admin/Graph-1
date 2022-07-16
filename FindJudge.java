//time complexity : O(V+E) V = numbe of node, E = number of edges
//space complexity : O(1)

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n];

        for(int[] t : trust) {

            indegrees[t[0]-1]--; //giving trust
            indegrees[t[1]-1]++; //recieving trust
        }

        for(int i=0; i<indegrees.length; i++) {
            if(indegrees[i] == n-1)
                return i+1;
        }
        return -1;
    }
}
