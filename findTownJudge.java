// Time Complexity : O(V+E), V is the vertex and E is the Edge
// Space Complexity : O(V)

// Your code here along with comments explaining your approach
/* In this problem , we keep track of the indegree of every vertex. 
 * We go through the trust array and and increment and decrement the count for the incomming and outgoing edges.
 * if the indegree of any vertiex is equal to n-1 ie. all the other people trust that node, that means that is the judge else return -1;
 */  
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegrees = new int[n+1];
        for(int[] pair : trust)
        {
            indegrees[pair[0]] --;
            indegrees[pair[1]] ++;
        }

        for(int i = 1 ; i < indegrees.length; i++)
        {
            if(indegrees[i] == n-1)
                return i;
        }

        return -1;
        
    }
}