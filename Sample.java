// Time Complexity :O(v+e) v is vertices and e is number of edges
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] indegrees = new int[n];
        for(int [] tr : trust){
            indegrees[tr[0]-1]--;
            indegrees[tr[1]-1]++;
        }
        for(int i =0;i<n;i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}
