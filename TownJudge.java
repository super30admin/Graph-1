// Time Complexity - O(n) n = no of people
// Space Complexity - O(n) n = indegree array length

// Approach
// Since judge doesnt trust anyone the outdegree must be 0 and since everyone trusts him,
// there is a directed edge towards judge from each and every node(N-1). Hence, we count the
// indegree for each of the nodes and the node with indegree = N-1 is town judge

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N];
        for(int[] i:trust) {
            indegree[i[1]-1]++;
            indegree[i[0]-1]--;
        }
        for(int i=0;i<N;i++) {
            if(indegree[i]== N-1) return i+1;
        }
        return -1;
    }
}