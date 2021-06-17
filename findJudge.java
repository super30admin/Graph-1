class Solution {
    public int findJudge(int n, int[][] trust) {
        //if(trust == null || trust.length == 0 || trust[0].length == 0) return -1;
        int [] indegree = new int[n];
        for(int [] t : trust){
            int i = t[0];
            int k = t[1];
            indegree[k - 1]++;
            indegree[i - 1]--;
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == n - 1) return i + 1;
        }
        return -1;
    }
}
