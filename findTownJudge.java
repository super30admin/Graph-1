 // Time Complexity : O(V + E)
// Space Complexity : O(V) --> O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];
        
        for (int[] pair : trust) {
            degree[pair[0]]--;
            degree[pair[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n-1)
                return i;
        }
        return -1;
    }
}