// Time Complexity : O(v+e) (vertices and edges)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class TownJudge {
    public int findJudge(int N, int[][] trust){
        int[] indegrees = new int[N];
        for(int [] t: trust){
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i = 0; i < N; i++){
            if(indegrees[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }

}