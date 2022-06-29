// Time Complexity : O(E)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class TownJudge {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] indegrees = new int[n];
            for(int[] t : trust)  {
                indegrees[t[1] - 1] +=1;
                indegrees[t[0] - 1] -=1;
            }

            for(int i=0; i<n; i++) {
                if(indegrees[i] == n-1)
                    return i+1;
            }

            return -1;
        }
    }
}
