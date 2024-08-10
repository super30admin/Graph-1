/****
 Using Graph
 TC - O(m)
 SC - O(n)

 Approach -
 1. Calculate Indegree and outdegree for each label
 2. Add 1 for Indegree and Subtract 1 for Outdegree
 3. Return the label who has (indegree + outdegree) = n-1
 */


class TownJudge {
    public int findJudge(int n, int[][] trust) {

        if(n == 0)
            return -1;

        int[] inOutDegree = new int[n];

        for(int[] t : trust) {
            inOutDegree[t[0]-1]--;
            inOutDegree[t[1]-1]++;
        }

        for(int i =0; i < n; i++) {
            if(inOutDegree[i] == n-1)
                return i+1;
        }

        return -1;
    }
}