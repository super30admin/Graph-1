// Time Complexity : O(E + V), V-length of trust array, E-number of people
// Space Complexity : O(n), for indegree array
// Did this code successfully run on Leetcode : Yes

// Approach:
// Create an array to track how many people each person trusts (decrease) and is trusted by (increase).
// The town judge should be trusted by everyone else (n - 1) people and trust no one.
// Loop through the array and return the person who has exactly (n - 1) trust score.

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees=new int[n+1];
        for(int[] tr:trust){
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(indegrees[i]==n-1) return i;
        }
        return -1;
    }
}