//Time Complexity: O(V+E)
//Space Complexity: O(V)

//Successfully runs on leetcode: 3 ms

//Approach: To find the judge, we ened to find a vertex for which there should be incoming edges from all the other vertices
//and there should be no outgoing edges. So we create an indegree array and the vertex for which the indegree value is equal
//to N-1 is the required judge.

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N];
        for(int[] t: trust)
        {
            indegree[t[0] - 1]--;
            indegree[t[1] - 1]++;
        }
        
        for(int i = 0; i < N; i++)
        {
            if(indegree[i] == N - 1)
                return i+1;
        }
        return -1;
    }
}