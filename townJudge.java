// Time Complexity : (V+E) where V is the number of vertices and E is the number of edges
// Space Complexity : O(V) where V is the number of vertices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. For each trust entry, reduce the person who is trusting and increase the person who is trusted.
 * 2. The judge will be the person who is trusted by everyone else and trusts no one which is n-1.
 * 3. If there is n-1 count at index i, i is the town judge.
 * 4. If there is no such person, return -1.
 */


class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustarr = new int[n+1];
        for(int[] t : trust){
            trustarr[t[0]]--;
            trustarr[t[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(trustarr[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}