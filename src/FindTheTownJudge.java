// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * This is a graph approach where the indegrees are maintained as if the person is going to be trusting another person, the value will be -1 
 * and decreasing further accordingly; when a person is trusted then its indegrees value will be incremented by 1
 * the value if the actual judge will be returned if and only if the indegree value is equal to N-1
 * else returns -1 depicting no judge is present.
 */

public class FindTheTownJudge {
	public int findJudge(int N, int[][] trust) {
        int [] indegrees = new int[N];
        for(int [] t : trust){
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
