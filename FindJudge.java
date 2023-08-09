/* TC = O(m+n) i.e. O(V+E) as we go over all the connections first i.e. trust array elements 
i.e all edges and then go over all the unique nodes i.e. 'n' i.e. all the vertices i.e. O(n) 
SC = O(V) - for indegrees array -- check once
*/ 
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int m = trust.length;
        for(int i=0;i<m;i++){
            indegree[trust[i][0] - 1]--;    //outgoing for every outgoing trust, -1 done to manage the array index as index starts from 0
            indegree[trust[i][1] - 1]++;   //increment for every incoming trust, -1 done to manage the array index as index starts from 0         
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == n-1) return i+1; // n-1 to signify that all others except the judge trusts him
        }
        return -1;
    }
}