// TC: O(max(V, E)) -> V :No. of people, E -> trust.length
// SC: O(V) : V -> No. of people
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N-1)
            return -1;
        
        int[] trustScores = new int[N+1];
        for (int[] relation : trust)
        {
            //outdegree
            trustScores[relation[0]]--;
            //indegree
            trustScores[relation[1]]++;
        }
        // start from 1 because people are numbered from 1 to N
        for (int i = 1; i <= N; i++)
        {
            // if indegree-outdegree == N-1, he is the town judge
            if (trustScores[i] == N-1)
                return i;
        }
        return -1;
    }
}
