// v+e
// v
// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0){
            return -1;
        }

        int[] indegree = new int[n]; // for finding out the judge
        for(int[] trustees : trust){
            int trustee = trustees[0]; // person who is trusting
            int trusted = trustees[1]; // person who is trusted
            indegree[trustee - 1]--;
            indegree[trusted - 1]++;
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == n - 1){
                return i + 1;
            }
        }

        return -1;
    }
}