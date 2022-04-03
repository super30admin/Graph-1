// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Loop through the trust array and store the indegrees and outdegrees of all the nodes
// The judge should have outdegree 0 and indegree n-1
// We will find it using traversal through the stored array and return the judge index

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] outDegree = new int[n+1];
        int [] inDegree = new int[n+1];
        for(int[] edge: trust){
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        for(int i = 1; i <=n; i++){
            if(inDegree[i] == n-1)
                if(outDegree[i] == 0)
                    return i;
        }
        return -1;
    }
}