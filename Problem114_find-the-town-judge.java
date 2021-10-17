// Time Complexity: O(V + E)
// Space Complexity: O(N)
import java.util.*;
class Solution {
    public int findJudge(int n, int[][] trust) {    
        int[] relation = new int[n];
        Arrays.fill(relation, 0);
        for(int[] t: trust) {
            relation[t[0] - 1]--;
            relation[t[1] - 1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(relation[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}