// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FindJudge {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] inDeg = new int[n + 1];
            int result = -1;

            for(int[] pair : trust){
                inDeg[pair[0]]--;
                inDeg[pair[1]]++;
            }

            int max = inDeg[0];
            for(int i = 1; i < n+1; i++){
                if(inDeg[i] == n - 1)
                    result = i;
            }

            return result;
        }
    }
}
