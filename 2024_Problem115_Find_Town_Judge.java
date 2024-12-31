//997. Find the Town Judge - https://leetcode.com/problems/find-the-town-judge/description/
//Time Complexity: O(E) + O(V) ~ going over edges to create indegree
//                              going over vertices to search for n-1 judge
//Space Complexity: O(V)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];

        for(int[] tr: trust){
            //[1,2] -> 1 trusts 2, indegree[1]--
            indegrees[tr[0]]--;
            //[1,2] -> 2 receives trust from 1, indegree[2]++
            indegrees[tr[1]]++;
        }

        for(int i=1; i<=n; i++){
            //n-1: except self, all other trusts
            if(indegrees[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}
