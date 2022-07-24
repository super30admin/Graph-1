// TIme Complexity: O(N)
// Space COmplexity: O(N)
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] t: trust){
            indegree[t[0] -1]--;
            indegree[t[1]-1]++;
        }

        for(int i=0 ; i<n; i++){
            if(indegree[i] == n-1)
                return i+1;
        }
        return -1;
    }
}
