// Time Complexity : O(n) --> where n is the length on input trust array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (997): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {
        //edge case
        if (trust == null) return -1;
        
        int indegree[] = new int[N+1];
        for (int t[] : trust) {
            indegree[t[0]]--;
            indegree[t[1]]++;
        }
        
        // find the town judge
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == N-1) return i;
        }
        return -1;
    }
}