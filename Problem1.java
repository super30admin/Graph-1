package Graph-1;
// TC: O(2n)
// SC: O(n+1)
public class Problem1 {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];

        for(int[] eachTrust: trust){
            indegree[eachTrust[0]]--;
            indegree[eachTrust[1]]++;
        }

        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
