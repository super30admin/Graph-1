//time O(n)
//space O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];
        int num = -1;
        for(int[] tru: trust) {
            indegrees[tru[1]-1]++;
            indegrees[tru[0]-1]--;
        }
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == n-1) num = i+1;
        }
        return num;
    }
}
