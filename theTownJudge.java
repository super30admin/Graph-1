/*
Problem: https://leetcode.com/problems/find-the-town-judge/
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 0) {
            return -1;
        }
        
        int indegrees[] = new int[n];
        
        for (int t[] : trust) {
            ++indegrees[t[1] - 1];
            --indegrees[t[0] - 1];
        }
        
        for (int i = 0; i < n; ++i) {
            if (indegrees[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}