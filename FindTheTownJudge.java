/**
 * TC: O(V + E) where V is the number of people in town and E is the number of trust relations
 * SC: O(N) where N is the number of people in the town
 * LeetCode: Y(https://leetcode.com/problems/find-the-town-judge/)
 * Approach:
    This is a graph problem where the people are nodes and the trust relationships are the directed edges between the nodes.
    For N people in the town, the judge is the one node whose in-degree is N - 1 and out-degree is 0
    So maintian an auxiliary array, which stores the in-degree and out-degree effecitvely by the following formula
    + 1 if you are trusted by somebody
    - 1 if you trust somebody
    after populating such an array, only the judge will have trust level equal to N - 1
 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        // edge case
        if(N == 0 || trust == null || N - 1 > trust.length) {
            return -1;
        }
        
        // intitialize in-degree out-degree array
        int[] trusts = new int[N];
        
        // populate the in-degree out-degree array
        for(int[] relation : trust) {
            trusts[relation[0] - 1]--;
            trusts[relation[1] - 1]++;
        }
        
        // iterate through the in-degree out-degree array
        for(int i = 0 ; i < trusts.length ; i++) {
            // check for the node (person) whose trust level is N - 1
            if(trusts[i] == N - 1) {
                return (i + 1);
            }
        }
        
        // no judge was found
        return -1;
    }
}
