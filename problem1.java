// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
Approach
we are using topological sort here , using array's index to represent people, if someone trusts a people we increase their count and decrease
the people who is trusting
in the next loop we check if someone has value equal to n-1 (n-1 mean part to the person it self everyone trusts him, and he does does not trust anyone or else n-1 is no possible)
we return that person
if that is not found that mean we don't have a judge 
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indgrees = new int[n + 1]; // 0
        for (int[] tr : trust) {
            indgrees[tr[0]]--;
            indgrees[tr[1]]++;
        }
        for (int i = 1; i < indgrees.length; i++) {
            if (indgrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}