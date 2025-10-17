// Time Complexity : O(V + E), where V is number of people and E is number of trust pairs.
// Space Complexity :O(V), for storing indegrees and outDegrees arrays.
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We keep track of number of people trusting each other using indegree and outdegree
//when a trusts b outdeg will decrease and b indeg will increase
//in the end we need to check if the outdeg becomes 0 to satisfy the first condition - The town judge trusts nobody.
//and check for second condition Everybody (except for the town judge) trusts the town judge. - check if indeg becomes equal to 1 less number of people
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdeg = new int[n+1];
        int[] indeg = new int[n+1];
        for (int[] tr: trust) {
            outdeg[tr[0]]--;
            indeg[tr[1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(outdeg[i] == 0 && indeg[i] == n-1) return i;
        }
        return -1;
    }
}
