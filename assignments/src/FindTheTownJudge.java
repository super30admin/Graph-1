// Approach: Calculate indegree and outdegree for each vertex in graph, check if any V has
// indegrees = n-1 and outdegrees = 0
// Here, indegrees = No. of people who trust him
// outdegrees = No. of people he trusts
// Time: O(E)
// Space: O(n)

class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {

        if (trust.length < N - 1) {
            return -1;
        }

        int[] indegrees = new int[N + 1];
        int[] outdegrees = new int[N + 1];

        for (int[] relation : trust) {
            outdegrees[relation[0]]++;
            indegrees[relation[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}