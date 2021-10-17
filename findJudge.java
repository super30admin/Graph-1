class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1) return 1;
        int[] indegrees = new int[n];
        for(int i=0; i< trust.length; i++) {
            indegrees[trust[i][0]-1] = indegrees[trust[i][0]-1] - 1;
            indegrees[trust[i][1]-1] = indegrees[trust[i][1]-1] + 1;
        }
        for(int i = 0; i< indegrees.length; i++) {
            if(indegrees[i]==n-1) return i+1;
        }
        return -1;
    }
}