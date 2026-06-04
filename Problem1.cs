// Time Complexity : O(V + E) where V is the total number of people and e is the edges present in the trust matrix 
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain an array inwardEdges wherein I for each person that a particular person trusts, I decrement it's corresponding value 
by 1 in the array and increment the value for the person who is trusted by 1. After traversing all the links in the trust 
array, I check to see that which person is trusted by all the other people and doesn't trust anyone themselves i.e value for inwardEdges
is n-1. That is my final answer. If such a person doesn't exist, I return -1.
*/

public class Solution {
    public int FindJudge(int n, int[][] trust) {
        int[] inwardEdges = new int[n];

        foreach(int[] arr in trust)
        {
            inwardEdges[arr[0] - 1] -= 1;
            inwardEdges[arr[1] - 1] += 1;
        }

        for(int i = 0; i < n; i++)
        {
            if(inwardEdges[i] == n-1)
            {
                return i+1;
            }
        }

        return -1;
    }
}