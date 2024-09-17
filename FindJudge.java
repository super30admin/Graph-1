//Time Complexity: O(n)
//Space Complexity: O(n)

public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[] indegrees = new int[N];
        for(int[] t: trust){
            indegrees[t[0] - 1]--;
            indegrees[t[1] - 1]++;
        }
        for(int i = 0; i < N; i++){
            if(indegrees[i] == N - 1) return (i + 1);
        }
        return -1;
    }
}
