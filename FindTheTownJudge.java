// Time Complexity : O(n) where n = length of the array
// Space Complexity : O(n) where n = number of people
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//997. Find the Town Judge (Easy) - https://leetcode.com/problems/find-the-town-judge/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n];
        
        // Decrease the value of person who is trusting other person by 1
        // Increase the person who is trusted by other person by 1
        for (int[] edge : trust) {
            inDegrees[edge[0] - 1]--;
            inDegrees[edge[1] - 1]++;
        }
        
        // Check for value of person whose value is equal to n-1, that means the person is trusted by all and he doesn't trust anyone
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == n-1) return i+1;
        }
        
        return -1;
    }
}