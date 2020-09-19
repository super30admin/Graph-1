//Time Complexity : O(N+trust.length)
//Space Complexity : O(n)
public class TownJudge{
    public int findJudge(int N, int[][] trust) {
        if(trust == null)return -1;
        int indegree[] = new int[N];
        for(int i = 0; i < trust.length ; i++){
            indegree[trust[i][0]-1]--;
            indegree[trust[i][1]-1]++;
        }
        for(int i = 0; i < N;i++){
            if(indegree[i] == N-1)return i+1;
        }
        return -1;
    }
}