// Time Complexity : O(m+n), m = trust array size, n = N (degree array size)
// Space Complexity : O(n), n = N (degree array size)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//TC : O(m+n), m = trust array size, n = N (degree array size)
//SC : O(n), n = N (degree array size)
//Find indegree and outdegree of all n-1 nodes, 
//if indegree (someone trusts this node) so increase the index(n) val by 1
//if outdegree (they trust someone) so decrease index(n) the val by 1
//as given town judge trusts no one and everyone trusts him, so val at this index will be n-1
//so to check if town judge exists, check if any index has val of n-1, if yes return that index
class Solution {
    public int findJudge(int N, int[][] trust) {
        //given n is between 1 and N
        //and trust len between 0 and 10^4
        //if trust len = 0 and N =1, return 1
        if(trust.length == 0 && N == 1) return 1; 
        if(trust == null || trust.length == 0) return -1;
        //degree of size N+1 as nodes start from 1
        int[] degree = new int[N+1];
        //inc count by 1 if node at index 1
        //dec count by 1 if node at index 0
        for(int i = 0; i < trust.length; i++) {
            degree[trust[i][0]]--;
            degree[trust[i][1]]++;          
        }
        
        //check from 1st node (index pos 1) to last node
        //if any node has val n-1, return i
        for(int i = 1; i < degree.length; i++) {
            if(degree[i] == N-1) return i;
        }
        //return -1, if no town judge exists
        return -1;
    }
}


