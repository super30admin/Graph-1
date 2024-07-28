/*
    LC - 997. Find the Town Judge
    TC - O(V + E)
    SC - O(V)
    Approach -  
        Relationship exists.
        calculate the indegrees for each vertices. Increment the t[1] if it is trusted by someone. Decrement t[0] who is trusting someone.
        if any of the indegrees is equal to n-1
        return that i+1;
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0) {
            return -1;
        }
        int[] indegrees = new int[n];
        for(int[] t: trust) {
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i=0; i<n; i++) {
            if(indegrees[i] == n-1) {
                return i + 1;
            }
        }
        return -1;
    }
}