// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust==null || trust.length==0) return 1;
        
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        for(int[] item : trust){
            indegree[item[1]]++;
            outdegree[item[0]]++;
        }
        for(int i = 1; i<=N;i++){
            if(indegree[i]==N-1 && outdegree[i]==0) return i;
        }
        return -1;
        }
}