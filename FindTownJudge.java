//Time Complexity: O(V+E) where v is n and E is length of trust array
//Space Complexity: O(V)
public class FindTownJudge {
    public int findJudge(int n, int[][] trust){
        int[] indegrees = new int[n];
        for(int[] t: trust){
            int in = t[1] - 1;
            int out = t[0] - 1;
            indegrees[out]--;
            indegrees[in]++;
        }
        for(int i = 0; i<indegrees.length; i++){
            if(indegrees[i] == n - 1){
                return i+1;

            }
        }
    return -1;
    }
}
