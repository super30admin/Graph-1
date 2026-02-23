/*
Time Complexity : O(n) - n people in the town
Space Complexity : O(n) - extra array
Approach :
We can maintain an indegree array for each person in town. If a person A trusts person B, we  increase B's indegree and
decrease A's indegree. Since all people should trust the judge, its indegree should be n-1. Since the judge trusts no one,
its indegree should remain at n-1. If no such person exists, we should return -1.
*/
public class TownJudge {
    public int findJudge(int n, int[][] trusts) {
        int[] indegree = new int[n+1];

        for(int[] trust :trusts){
            indegree[trust[0]]--;
            indegree[trust[1]]++;
        }

        for(int i = 1; i< n+1; i ++){
            if(indegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
