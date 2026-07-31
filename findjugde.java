// Time Complexity : O(n+e) where n is the number of nodes and e is the number of edges
// Space Complexity : O(n) for storing the inDegree and outDegree arrays
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : having the thought of indegree and outdegree of the nodes

// Your code here along with comments explaining your approach: started with the idea of indegree and outdegree of the nodes. The judge will have indegree of n-1 and outdegree of 0. So we can keep track of indegree and outdegree of each node and return the node which has indegree of n-1 and outdegree of 0.
class Solution {
    public int findJudge(int n, int[][] trust) {
        int []inDegree=new int[n+1];
        int []outDegree=new int[n+1];
        for(int[]relation:trust)
        {
            int a=relation[0];
            int b= relation[1];
            outDegree[a]++;
            inDegree[b]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(outDegree[i]==0 && inDegree[i]==n-1)
            {
                    return i;
            }
        }
        return -1;
    }
}