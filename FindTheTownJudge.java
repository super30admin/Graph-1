public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
//        Time Complexity: O(E)
//        Space Complexity: O(N)
        int[] indegrees = new int[n+1];
        for(int[] tr: trust){
            indegrees[tr[1]]++;
            indegrees[tr[0]]--;  //he trusts no one thi will consider the case when there are 2 people trusted by everyone else
        }
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == n-1) return i;
        }
        return -1;
    }
}
