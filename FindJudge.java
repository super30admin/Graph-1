
//TC - O(V+E)
//SC -O(V)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        for(int[] t : trust){
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }

        for(int i=0;i< indegree.length;i++){
            if(indegree[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}
