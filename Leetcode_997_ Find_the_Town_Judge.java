/*
approach -2
this is the graph problem
we take an adjaceny list for the incoming and outgoing edge
for the incoming edge, which is for the peron being trusted, we will update the index's value++
and for the person trusting we will do that index's vaue --;
//trusting  another person is  - Outward edge
//being trusted - is inward edge; which will be incremented. 

//tc - this is graph problem - O(V+E) -> V= vertices = n && E = trust.length() = m ==> O(m+n)
//sc - O(V) = O(n)
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0 || trust == null) return -1;
        
        int[] indegrees = new int[n+1];

        for(int[]  pair : trust)
        {
            indegrees[pair[0]]--;
            indegrees[pair[1]]++;
        }
        //traverse through the indegrees
        for(int i=1; i<n+1; i++)
        {
            if(indegrees[i] == n-1) return i;
        }
        return -1;
    }
}